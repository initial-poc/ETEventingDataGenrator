package com.infogain.et.tg.entity;

import com.google.cloud.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OutboxEntity {
    private String locator;
    private long version;
    private Timestamp created;
    private String payload;
    private long status;
    private int retry_count;
    private Timestamp updated;
    private long processing_time_millis;
    private String parentPnr;
}