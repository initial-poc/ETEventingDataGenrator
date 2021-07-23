package com.infogain.et.tg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorServiceConfig {

    @Value("${scheduler.pool.size}")
    private int corePoolSize;

    @Bean("fixedThreadPool")
    public ExecutorService fixedScheduledThreadPool() {
        return Executors.newFixedThreadPool(corePoolSize);
    }
}