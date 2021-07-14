package com.infogain.et.event.service;

import com.google.cloud.Timestamp;
import com.infogain.et.event.dto.CSVDataDTO;
import com.infogain.et.event.entity.OutboxEntity;
import com.infogain.et.event.repository.OutboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OutboxService {

    private final OutboxRepository outboxRepository;

    public void saveOutbox(Set<CSVDataDTO> cSVDataDTOSet) {


        log.info("time stamp before saving data {}", Timestamp.now());
        Set<OutboxEntity> outboxEntitySet =
                cSVDataDTOSet.stream().map(CSVDataDTO::buildEntity).collect(Collectors.toSet());

        outboxRepository.saveOutboxDataUSingMutation(outboxEntitySet);

        log.info("saving data in database");

        System.out.println("execution save method ");
        log.info("data saved in database successfully");
    }
}