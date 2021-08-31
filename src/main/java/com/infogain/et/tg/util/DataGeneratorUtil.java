package com.infogain.et.tg.util;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

import java.util.Map;
import java.util.Random;
import java.util.zip.CRC32;

public class DataGeneratorUtil {

    public static final int NO_OF_SHARDS = 100;

    public static final Map<Integer, String> ITERNARY_MAP = Map.of(
            1, "\"itinerary\" : \"LHR-DEL\"",
            2, "\"teleType\" : \"Business\"",
            3, "\"eticket\" :  \"234246\"",
            4, "\"itinerary\" : \"LHR-DEL\", \"teleType\" : \"Business\"",
            5, "\"itinerary\" : \"LHR-DEL\", \"eticket\" :  \"234246\"",
            6, "\"itinerary\" : \"LHR-DEL\", \"eticket\" :  \"234246\", \"teleType :  \"Business\""
    );
    static char[] alphaDigitArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    private DataGeneratorUtil() {
    }

    /**
     * Get Locator prefix from the range A to Z/a-z/0-9
     *
     * @return pnr
     */
    public static String getRandomPNRId() {
        Random random = new Random();
        return NanoIdUtils.randomNanoId(random, alphaDigitArray, 6);
    }

    public static Long getPnrShardId(String pnrId) {
        CRC32 hash = new CRC32();
        String data = pnrId + System.currentTimeMillis();
        hash.update(data.getBytes());
        long value = hash.getValue();
        return value % NO_OF_SHARDS;
    }

}
