package com.infogain.et.event.entity;

import com.google.cloud.Timestamp;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OutboxEntity {
    private String locator;
    private long version;
    private String payloadType;
    private Timestamp created;
    private String payload;
    private long status;
    private int retry_count;
    private Timestamp updated;
    private long processing_time_millis;
    private String parentPnr;
}