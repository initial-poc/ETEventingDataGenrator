package com.infogain.et.event.service;

import com.infogain.et.event.EtEventingDataGenratorApplication;
import com.infogain.et.event.dto.CSVDataDTO;
import com.infogain.et.event.util.Constant;
import com.infogain.et.event.util.DataGeneratorUtility;
import com.infogain.et.event.util.FileOPeration;
import com.infogain.et.event.util.PNROperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Stream;

@Deprecated
public class EventDataGenerator {

    @Autowired
    OutboxService outboxService;

    public static void main(String[] args) {
        SpringApplication.run(EtEventingDataGenratorApplication.class, args);
    }

    public void doProcess() throws Exception {
        System.out.println("============== ET EVENTING DATA GENERATOR ==============");
        Scanner inputData = null;
        FileWriter csvWriter = null;
        try {
            /** 1. Get Input from user */
            inputData = new Scanner(System.in);
            System.out.println("Enter total number of records to be generated : ");
            while (!inputData.hasNextInt()) {
                System.out.println("Please enter numeric value : ");
                inputData.next();
            }
            Integer inputRecords = inputData.nextInt();

            // Get version limit as per given input records
            Integer versionLimit = DataGeneratorUtility.getVersionLimit(inputRecords);

            String fileName = FileOPeration.getFileName(inputRecords);

            // Create CSV File set header data
            csvWriter = new FileWriter(fileName);
            csvWriter.append(Constant.CSV_HEADER);
            csvWriter.append(Constant.NEWLINE);

            // Locator map which stores all locators with default value which will used to create locator version sequencing
            Map<String, Integer> locatorVersionMap = new HashMap<>();

            // Parent Data Keeper : Will keep all the version 1 and 2 locator data and will be appended first
            Set<CSVDataDTO> parentDataKeeper = new HashSet<>();

            // Rest of version data will be kept here and this data will be added later
            Set<CSVDataDTO> dataKeeper = new HashSet<>();

            PNROperation
                    .setLocatorAndVersion(inputRecords, versionLimit, locatorVersionMap, parentDataKeeper, dataKeeper);

            // Write data in CSV
            for (CSVDataDTO data : parentDataKeeper) {
                FileOPeration.writeInCSV(data, csvWriter, locatorVersionMap);
            }
            for (CSVDataDTO data : dataKeeper) {
                FileOPeration.writeInCSV(data, csvWriter, locatorVersionMap);
            }

            Set<CSVDataDTO> mergedCsvData = new HashSet<>();
            Stream.of(parentDataKeeper, dataKeeper).forEach(mergedCsvData::addAll);
            outboxService.saveOutbox(mergedCsvData);

            File csvFile = new File(fileName);
            System.out.println("Processed file : " + csvFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (inputData != null)
                inputData.close();
            csvWriter.flush();
            csvWriter.close();
        }
    }
}