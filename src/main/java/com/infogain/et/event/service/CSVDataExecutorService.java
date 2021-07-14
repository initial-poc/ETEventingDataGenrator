package com.infogain.et.event.service;

import com.infogain.et.event.dto.CSVDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CSVDataExecutorService {

    @Autowired
    @Qualifier("scheduleThreadPool")
    private ScheduledExecutorService executorService;

    @Autowired
    private OutboxService outboxService;

    @Value("${scheduler.delay.interval:1}")
    private int delayInterval;

    public void processData(Set<CSVDataDTO> dtoSet) {
        log.info("Records:: {} sending to OutBox service to persist", dtoSet.size());
        for(CSVDataDTO dto : dtoSet) {
            executorService.scheduleAtFixedRate(() -> {
            //    log.info("Records:: {} sending to OutBox service to persist", dtoSet.size());
                outboxService.saveOutbox(dtoSet);

            }, 0, delayInterval, TimeUnit.SECONDS);
        }
    }

}