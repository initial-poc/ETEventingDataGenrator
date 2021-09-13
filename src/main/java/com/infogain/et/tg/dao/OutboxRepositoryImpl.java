package com.infogain.et.tg.dao;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Value;
import com.google.common.base.Stopwatch;
import com.infogain.et.tg.entity.OutboxEntity;
import com.infogain.et.tg.util.EtConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Slf4j
@Repository
@RequiredArgsConstructor
public class OutboxRepositoryImpl implements OutboxRepository {
    private final DatabaseClient databaseClient;
    @org.springframework.beans.factory.annotation.Value("${table.name}")
    private String tableName;

    @Override
    public void saveAll(Set<OutboxEntity> outboxEntitySet) {
        List<Mutation> mutations = new ArrayList<>();

        outboxEntitySet.forEach(outboxEntity -> mutations.add(
                Mutation.newInsertBuilder(tableName)
                        .set(EtConstants.LOCATOR)
                        .to(outboxEntity.getLocator())
                        .set(EtConstants.VERSION)
                        .to(outboxEntity.getVersion())
                        .set(EtConstants.CREATED)
                        .to(Value.COMMIT_TIMESTAMP)
                        .set(EtConstants.PAYLOAD)
                        .to(outboxEntity.getPayload())
                        .set(EtConstants.STATUS)
                        .to(outboxEntity.getStatus())
                        .build()));

        databaseClient.write(mutations);
    }

    @Override
    public void save(OutboxEntity outboxEntity) {
        List<Mutation> mutations = new ArrayList<>();

        Stopwatch started = Stopwatch.createStarted();
        mutations.add(
               // Mutation.newInsertBuilder(EtConstants.OUTBOX)
                Mutation.newInsertBuilder(tableName)
                        .set(EtConstants.LOCATOR)
                        .to(outboxEntity.getLocator())
                        .set(EtConstants.VERSION)
                        .to(outboxEntity.getVersion())
                        .set(EtConstants.CREATED)
                        .to(Value.COMMIT_TIMESTAMP)
                        .set(EtConstants.PAYLOAD)
                        .to(outboxEntity.getPayload())
                        .set(EtConstants.STATUS)
                        .to(outboxEntity.getStatus())
                        .set(EtConstants.SHARD).to(outboxEntity.getPnrEventShardId())
                        .build());

        databaseClient.write(mutations);
      //  log.info("Time taken to Store record in table:: {}", started.stop());
    }
}
