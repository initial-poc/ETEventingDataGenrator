package com.infogain.et.event.dto;

import com.google.cloud.Timestamp;
import com.infogain.et.event.entity.OutboxEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class CSVDataDTO {

    String locator;
    String version;
    String parent_locator;
    String data;
    String payload_type;
    String status;

    @SneakyThrows
    public OutboxEntity buildEntity() {
        OutboxEntity outboxEntity = new OutboxEntity();
        outboxEntity.setLocator(locator);
        outboxEntity.setVersion(Long.parseLong(version));
        outboxEntity.setParentPnr(parent_locator);
        outboxEntity.setPayload(data);
        outboxEntity.setPayloadType(payload_type);
        outboxEntity.setCreated(Timestamp.now());
        outboxEntity.setStatus(0);

        //TODO: change csv to get this value.
        //outboxEntity.setUpdated(Timestamp.now());
        return outboxEntity;
    }

}
