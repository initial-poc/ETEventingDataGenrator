package com.infogain.et.tg;

import com.infogain.et.tg.service.TrafficGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TrafficGeneratorApp implements CommandLineRunner {

    @Autowired
    TrafficGeneratorService trafficGeneratorService;

    public static void main(String[] args) {
        SpringApplication.run(TrafficGeneratorApp.class, args);
    }

    @Override
    public void run(String... args) {
        trafficGeneratorService.process();
    }
}
