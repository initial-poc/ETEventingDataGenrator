package com.infogain.et.event.service;

import com.infogain.et.event.dto.CSVDataDTO;
import com.infogain.et.event.dto.PayloadEnum;
import com.infogain.et.event.util.Constant;
import com.infogain.et.event.util.DataGeneratorUtility;
import com.infogain.et.event.util.FileOPeration;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class TrafficGenerator {

    private static final String MAX_TPS = "Enter Number of TPS to be Processed : ";
    Random random = new Random();
    Object[] values = DataGeneratorUtility.ITERNARY_MAP.values().toArray();

    @Value("${tps}")
    private Integer maxTPS;
    @Value("${max.version.replicate:2}")
    private int maxVersionReplicate;
    @Value("${max.records.file:100}")
    private int inputRecordsSize;

    @Value("${max.time.run.process}")
    private int maxTimeToRunProcess;
    @Autowired
    private Serializer serializer;

    public void process() throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, InterruptedException, IOException {

        //Get User Input for Record processing

        long startTime = System.currentTimeMillis();
        long maxTimeInMilliSec = TimeUnit.SECONDS.toMillis(maxTimeToRunProcess);
        while ((System.currentTimeMillis() - startTime) < maxTimeInMilliSec) {
            Set<CSVDataDTO> csvDataSet = this.populateCSV(inputRecordsSize, 1);
            String fileName = FileOPeration.getFileName(inputRecordsSize);
            serializer.serializeDataToFile(csvDataSet, fileName);
            processDataByTPS(csvDataSet, fileName, maxTPS);
        }
    }

    private Set<CSVDataDTO> populateCSV(int inputRecordsSize, int version) {
        Set<CSVDataDTO> dataSet = new HashSet<>();

        for (int i = 0; i < inputRecordsSize; i++) {
            CSVDataDTO dataDto = new CSVDataDTO();
            dataDto.setLocator(DataGeneratorUtility.getRandomPNRId());
            dataDto.setVersion(String.valueOf(version));
            dataDto.setPayload_type(PayloadEnum.randomPayload());
            dataDto.setData(
                    Constant.DTO_DATA.substring(0, Constant.DTO_DATA.length() - 1) + Constant.COMMA + values[random.nextInt(values.length)]
                            + Constant.DTO_DATA.charAt(Constant.DTO_DATA.length() - 1));
            dataSet.add(dataDto);
        }
        return dataSet;
    }

    private void processDataByTPS(Set<CSVDataDTO> csvDataSet, String fileName, int maxTPS) throws IOException, InterruptedException {
        log.info("processing file {}", fileName);
        AtomicInteger version = new AtomicInteger(1);
        Files.deleteIfExists(Paths.get(fileName));
        log.info("file:: {} deleted successfully!!!", fileName);
        for (int i = 1; i < maxVersionReplicate; i++) {
            serializer.processSetToChunksByTPS(csvDataSet, maxTPS);
            int versionCount = version.incrementAndGet();
            csvDataSet.forEach(dto -> dto.setVersion(String.valueOf(versionCount))); //

        }
    }

    private int getClientRequestByInfo(String reqInfo, Scanner scanner) {
        System.out.println(reqInfo);
        while (!scanner.hasNextInt()) {
            log.info("Please Enter Numeric Value : ");
            scanner.next();
        }
        return scanner.nextInt();
    }

}
