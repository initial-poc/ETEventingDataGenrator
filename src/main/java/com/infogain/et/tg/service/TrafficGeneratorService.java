package com.infogain.et.tg.service;

import com.google.common.base.Stopwatch;
import com.infogain.et.tg.model.OutboxModel;
import com.infogain.et.tg.util.DataGeneratorUtil;
import com.infogain.et.tg.util.EtConstants;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Service
@Data
public class TrafficGeneratorService {
    private static final String MAX_TPS = "Enter Number of TPS to be Processed : ";
    Random random = new Random();
    Object[] itineraryMapArray = DataGeneratorUtil.ITERNARY_MAP.values().toArray();
    @Autowired
    OutboxService outboxService;
    @Value("${tps}")
    private Integer maxTPS;
    @Value("${max.version.replicate}")
    private int maxVersionReplicate;
    @Value("${max.data.limit}")
    private int maxDataLimit;

    private int inputRecordsSize;
    private volatile int recordCount;

    public void process() {
        var started = Stopwatch.createStarted();
        log.info("started the application of time... {}", started);
        //  inputRecordsSize = maxDataLimit * 3;
        inputRecordsSize=maxTPS*2;
        while (recordCount <= maxDataLimit) {
            log.info("Starts Processing Data Generation !!!");

            Set<OutboxModel> outboxModelSet = this.populateDataByRecordSize(inputRecordsSize, 1);
            log.info("Data created with size {}",outboxModelSet.size());
            var version = new AtomicInteger(1);

            for (var i = 1; i < maxVersionReplicate; i++) {
                if (this.processSetToChunksByTPS(outboxModelSet, maxTPS))
                    break;
                int versionCount = version.incrementAndGet();
                outboxModelSet.forEach(dto -> dto.setVersion(String.valueOf(versionCount)));
            }
        }
        log.info("Application is going to shutdown... {}", started.stop());
    }

    private Set<OutboxModel> populateDataByRecordSize(int inputRecordsSize, int version) {
        Set<OutboxModel> dataSet = new HashSet<>();
        String randomPNRId = "";
        for (var i = 0; i < inputRecordsSize; i++) {

            randomPNRId = DataGeneratorUtil.getRandomPNRId();
            long pnrShardId = DataGeneratorUtil.getPnrShardId(randomPNRId);

            dataSet.add(OutboxModel.builder().locator(randomPNRId).version(String.valueOf(version))
                    .version(String.valueOf(version)).data(
                            (EtConstants.DATA.substring(0, EtConstants.DATA.length() - 1) + EtConstants.COMMA + itineraryMapArray[random.nextInt(itineraryMapArray.length)]
                                    + EtConstants.DATA.charAt(EtConstants.DATA.length() - 1)) + EtConstants.DATA).pnrEventShardId(pnrShardId).build());
        }
        return dataSet;
    }


    public boolean processSetToChunksByTPS(Set<OutboxModel> dataSet, int maxTPS) {

        Iterator<OutboxModel> csvIterator = dataSet.iterator();
        Set<OutboxModel> resultSet = new HashSet<>();
        for (var i = 1; csvIterator.hasNext(); i++) {
            recordCount++;
            if (recordCount > maxDataLimit) break;
            resultSet.add(csvIterator.next());
            if (i == maxTPS) {
                log.info("Going to store of records size:: with tps {}", resultSet.size());
                processRecordOnDelay(resultSet);
                i = 0;
            }
        }
        if (!resultSet.isEmpty()) {
            log.info("Going to store of records size:: {}", resultSet.size());
            processRecordOnDelay(resultSet);
            if (recordCount > maxDataLimit)
                return true;
        }

        log.info("Processed Chunks Successfully !!!");
        return false;
    }

    private void processRecordOnDelay(Set<OutboxModel> resultSet) {
        outboxService.processData(resultSet.stream().map(OutboxModel::buildEntity).collect(Collectors.toSet()));
        resultSet.clear();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        log.info("data saved on outbox table");
    }
}
