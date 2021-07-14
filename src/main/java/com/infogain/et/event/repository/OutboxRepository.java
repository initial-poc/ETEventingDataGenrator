package com.infogain.et.event.repository;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Value;
import com.google.common.base.Stopwatch;
import com.infogain.et.event.entity.OutboxEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Slf4j
@Repository
@RequiredArgsConstructor
public class OutboxRepository {

    private final DatabaseClient databaseClient;


    public void saveOutboxDataUSingMutation(Set<OutboxEntity> outboxEntityList) {
        log.info("saving data in database...");
        List<Mutation> mutations = new ArrayList<>();
        outboxEntityList.forEach(outboxEntity -> mutations.add(
                Mutation.newInsertBuilder("OUTBOX")
                        .set("locator")
                        .to(outboxEntity.getLocator())
                        .set("version")
                        .to(outboxEntity.getVersion())
                        .set("payload_type")
                        .to(outboxEntity.getPayloadType())
                        .set("created")
                        .to(Value.COMMIT_TIMESTAMP)
                        .set("payload")
                        .to(outboxEntity.getPayload())
                        .set("status")
                        .to(outboxEntity.getStatus())
                        .build()));
        var started = Stopwatch.createStarted();
        databaseClient.write(mutations);

        log.info("Time taken:: {} to persist Records of size:: {}", started.stop(), outboxEntityList.size());

    }
}