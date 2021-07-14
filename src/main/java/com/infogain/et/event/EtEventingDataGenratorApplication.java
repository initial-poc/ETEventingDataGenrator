package com.infogain.et.event;

import com.infogain.et.event.service.TrafficGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EtEventingDataGenratorApplication implements CommandLineRunner {

    @Autowired
    TrafficGenerator trafficGenerator;

    public static void main(String[] args) {
        SpringApplication.run(EtEventingDataGenratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
            trafficGenerator.process();
    }
}
