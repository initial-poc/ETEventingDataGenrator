package com.infogain.et.event.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import com.infogain.et.event.dto.CSVDataDTO;

public class FileOPeration {
    /** Write in CSV file
     * @param data
     * @param csvWriter
     * @param locatorVersionMap
     */
    public static void writeInCSV(CSVDataDTO data, FileWriter csvWriter, Map<String, Integer> locatorVersionMap) {
        try {
            Integer versionVal = locatorVersionMap.get(data.getLocator());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            csvWriter.append(data.getLocator() + Constant.COMMA + versionVal + Constant.COMMA + data.getParent_locator()
                    + Constant.COMMA + timestamp.toInstant() + Constant.COMMA + data.getData());
            locatorVersionMap.put(data.getLocator(), ++versionVal);
            csvWriter.append(Constant.NEWLINE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Create File Name
     * @param inputRecords
     * @return
     */
    public  static String getFileName(Integer inputRecords) {
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        String fileName = inputRecords + Constant.UNDERSCORE + currentTimeStamp.getTime() + Constant.CSV_EXT;
        return fileName;
    }

    public static String createAndRenameFile(String fileName) {
        File from = new File(fileName);
        String newFileName = getFileName(Integer.parseInt(fileName.substring(0, fileName.indexOf('_'))));
        from.renameTo(new File(newFileName));
        return newFileName;
    }
}
