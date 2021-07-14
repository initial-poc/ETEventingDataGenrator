package com.infogain.et.event.util;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

import java.util.Map;
import java.util.Random;

public class DataGeneratorUtility {

    public static final Map<Integer, String> ITERNARY_MAP = Map.of(
            1, "\"itinerary\" : \"LHR-DEL\"",
            2, "\"teleType\" : \"Business\"",
            3, "\"eticket\" :  \"234246\"",
            4, "\"itinerary\" : \"LHR-DEL\", \"teleType\" : \"Business\"",
            5, "\"itinerary\" : \"LHR-DEL\", \"eticket\" :  \"234246\"",
            6, "\"itinerary\" : \"LHR-DEL\", \"eticket\" :  \"234246\", \"teleType :  \"Business\""
    );
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private DataGeneratorUtility() {

    }

    /**
     * Get Locator prefix from the range A to Z
     *
     * @return
     */
    public static String getPNRPrefix() {
        int leftLimit = Constant.ASCII_A; // letter 'A'
        int rightLimit = Constant.ASCII_Z; // letter 'Z'
        int targetStringLength = 1;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + Constant.ONE)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /**
     * Based on Total Records, it will fetch version
     *
     * @param totalRecords
     * @return
     */
    public static Integer getVersionLimit(Integer totalRecords) {
        if (totalRecords < Constant.TEN_THOUSAND) {
            return Constant.TEN;
        } else if (totalRecords > Constant.TEN_THOUSAND && totalRecords < Constant.ONE_LAKH) {
            return Constant.TWENTY;
        } else {
            return Constant.THIRTY;
        }
    }

    /**
     * Get Random Version as per given Max Limit
     *
     * @param maxLimit
     * @return
     */
    public static Integer getRandomVersion(Integer maxLimit) {
        Random random = new Random();
        return random.ints(Constant.ONE, maxLimit).findFirst().getAsInt();
    }

    /**
     * Get Locator prefix from the range A to Z/a-z/0-9
     *
     * @return pnr
     */
    public static String getRandomPNRId() {
        Random random = new Random();
        return NanoIdUtils.randomNanoId(random, alphabet, 6);
    }
}

