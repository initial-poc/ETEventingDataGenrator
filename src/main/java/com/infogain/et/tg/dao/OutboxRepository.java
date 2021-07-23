package com.infogain.et.tg.dao;

import com.infogain.et.tg.entity.OutboxEntity;

import java.util.Set;

public interface OutboxRepository {

    void saveAll(Set<OutboxEntity> outboxEntitySet);

    void save(OutboxEntity outboxEntity);
}