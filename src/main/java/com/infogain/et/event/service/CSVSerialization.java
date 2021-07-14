package com.infogain.et.event.service;

import com.infogain.et.event.dto.CSVDataDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CSVSerialization implements Serializer {

    @Autowired
    CSVDataExecutorService dataExeService;

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void mapCSVFileToBean(String fileName, Class<T> targetBean, int tps) throws IOException, InterruptedException {

        log.info("FileName:: {} is going to process ", fileName);
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName))) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(targetBean)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVDataDTO> csvIterator = (Iterator<CSVDataDTO>) csvToBean.iterator();
            processChunks(tps, csvIterator);
            log.info("FileName processed Successfully !!!");
        }

    }

    /**
     * {@inheritDoc}
     */

    @Override
    public <T> void processSetToChunksByTPS(Set<T> dataSet, int maxTPS) throws InterruptedException {
        Iterator<CSVDataDTO> csvIterator = (Iterator<CSVDataDTO>) dataSet.iterator();
        processChunks(maxTPS, csvIterator);
        log.info("DataSet processed Successfully !!!");
    }

    private void processChunks(int tps, Iterator<CSVDataDTO> csvIterator) throws InterruptedException {
        Set<CSVDataDTO> dtoSet = new HashSet<>();
        for (int i = 1; csvIterator.hasNext(); i++) {
            dtoSet.add(csvIterator.next());
            if (i == tps) {
                dataExeService.processData(dtoSet.stream().collect(Collectors.toUnmodifiableSet()));
                dtoSet.clear();
                i = 0;
            }
        }
        if (!dtoSet.isEmpty())
            dataExeService.processData(dtoSet);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void serializeDataToFile(Set<T> dataList, String fileName) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        log.info("DataList size:: {} is going to persist in in fileName:: {}",
                dataList.size(), fileName);
        try (Writer writer = Files.newBufferedWriter(Paths.get(fileName))) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .build();
            beanToCsv.write(dataList.stream());
            log.info("Exit successfully by persisting in file!!!");
        }
    }
}
