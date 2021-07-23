package com.infogain.et.tg.service;

import com.infogain.et.tg.dao.OutboxRepository;
import com.infogain.et.tg.entity.OutboxEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ExecutorService;

@Service
@Slf4j
public class OutboxService {
    @Autowired
    @Qualifier("fixedThreadPool")
    private ExecutorService executorService;
    @Autowired
    private OutboxRepository outboxRepository;
    @Value("${scheduler.delay.interval.process:60}")
    private int delayInterval;

    public void processData(Set<OutboxEntity> dtoSet) {  // 50
        dtoSet.forEach(dto -> {
            executorService.submit(() -> {
                outboxRepository.save(dto);
            }, 0);
        });
    }

//    public void processData(Set<OutboxEntity> dtoSet) {
//        executorService.scheduleWithFixedDelay(() -> {
//            log.info("outbox service processing...");
//            if (!dtoSet.isEmpty()) {
//                log.info("Records:: {} sending to OutBox service to persist", dtoSet.size());
//                outboxRepository.saveAll(dtoSet);
//                dtoSet.clear();
//            }
//        }, 0, delayInterval, TimeUnit.SECONDS);
//    }
}
