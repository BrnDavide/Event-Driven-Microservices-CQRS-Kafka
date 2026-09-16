package com.microservices.demo.ai.generated.tweet.to.kafka.service.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
/**
 * Needed to add this class for the TaskScheduler in
 */
public class SchedulerConfig {

    @Bean
    @Qualifier("taskScheduler")
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);
        scheduler.setThreadNamePrefix("ai-tweet-scheduler-");
        return scheduler;
    }
}
