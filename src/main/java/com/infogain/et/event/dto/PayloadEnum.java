package com.infogain.et.event.dto;

import java.util.List;
import java.util.Random;

public enum PayloadEnum {
    WORKING_COPY("Working Copy"), FILED_COPY("Filed Copy");

    private static final List<PayloadEnum> PAYLOADS = List.of(values());
    private static final int SIZE = PAYLOADS.size();
    private static final Random RANDOM = new Random();
    private final String payloadType;

    PayloadEnum(String payload) {
        this.payloadType = payload;
    }

    public static String randomPayload() {
        return PAYLOADS.get(RANDOM.nextInt(SIZE)).toString();
    }

    @Override
    public String toString() {
        return payloadType;
    }
}