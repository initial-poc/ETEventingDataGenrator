package com.infogain.et.tg.model;

import com.google.cloud.Timestamp;
import com.infogain.et.tg.entity.OutboxEntity;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;

@Builder
@Data
public class OutboxModel {
    String locator;
    String version;
    String parent_locator;
    String data;
    String payload_type;
    String status;
    Long pnrEventShardId;


    @SneakyThrows
    public OutboxEntity buildEntity() {
        return OutboxEntity.builder().locator(locator).version(Long.parseLong(version))
                .parentPnr(parent_locator).payload(data).status(0).created(Timestamp.now()).pnrEventShardId(pnrEventShardId).build();
        //TODO: change csv to get this value.
        //outboxEntity.setUpdated(Timestamp.now());
    }
}

