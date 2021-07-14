package com.infogain.et.event.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class ExecutorServiceConfig {

    @Value("${scheduler.pool.size:5}")
    private int corePoolSize;

    @Bean("scheduleThreadPool")
    public ScheduledExecutorService fixedScheduledThreadPool() {
        return Executors.newScheduledThreadPool(corePoolSize);
    }


}