package com.infogain.et.tg.config;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.SpannerOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SpannerDbClientConfig {

    @Value("${spanner.database.id}")
    private String databaseId;
    @Value("${spanner.instance.id}")
    private String instanceId;
    @Value("${spanner.project.id}")
    private String projectId;


    @Bean("databaseClient")
    public DatabaseClient configSpannerDB() {
        SpannerOptions options = SpannerOptions.newBuilder().build();
        var spanner = options.getService();
        return
                spanner.getDatabaseClient(DatabaseId.of(options.getProjectId(), instanceId, databaseId));
    }
}

