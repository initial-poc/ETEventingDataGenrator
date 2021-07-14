package com.infogain.et.event.config;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpannerDbClientConfig {

    @Value("${spanner.database.id}")
    private String databaseId;
    @Value("${spanner.instance.id}")
    private String instanceId;
    @Value("${spanner.project.id}")
    private String projectId;


    @Bean("databaseClient")
    public DatabaseClient getDatabaseClient() {
        SpannerOptions options = SpannerOptions.newBuilder().build();
        Spanner spanner = options.getService();
        DatabaseClient dbClient = null;

        try {
            // Creates a database client
            dbClient =
                    spanner.getDatabaseClient(DatabaseId.of(options.getProjectId(), instanceId, databaseId));

        } catch (Exception ex) {
            System.out.println("exception while building database client");
        }
        return dbClient;
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

}