package com.infogain.et.event.service;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.Set;

public interface Serializer {

    /**
     * Method to map csv data of given file to pojo
     *
     * @param dataList   dto list to persist
     * @param <T>        type
     * @param maxTPS     maximum transactions per second
     * @throws IOException if any ioException raised
     */

    <T> void processSetToChunksByTPS(Set<T> dataList, int maxTPS) throws IOException, InterruptedException;


    /**
     * Method to map csv data of given file to pojo
     *
     * @param fileName   fileName to persist
     * @param targetBean Bean to map
     * @param <T>        type
     * @param maxTPS     maximum transactions per second
     * @throws IOException if any ioException raised
     */

    <T> void mapCSVFileToBean(String fileName, Class<T> targetBean, int maxTPS) throws IOException, InterruptedException;


    /**
     * Method to persist the given dataList to given fileName
     *
     * @param dataList the data to persist
     * @param fileName name of the file
     * @param <T>      type bean
     * @throws IOException                    if any ioException raised
     * @throws CsvDataTypeMismatchException   if any csv dataType mismatch
     * @throws CsvRequiredFieldEmptyException if any required file missing
     */
    <T> void serializeDataToFile(Set<T> dataList, String fileName) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException;
}
