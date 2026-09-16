package com.microservices.demo.ai.generated.tweet.to.kafka.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Binding to the yaml.
 * Need @ConfigurationProperties to point at the correct configurations
 * Need the @Configuration so that it will become a Spring managed Bean
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ai-generated-tweet-to-kafka-service")
public class AIGeneratedTweetToKafkaServiceConfigData {

    // The list should match the properties in the yaml. Capitals in substitution of the dash
    private List<String> streamingDataKeywords;
    private long schedulerDurationSec;

}
