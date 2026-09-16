package com.microservices.demo.ai.generated.tweet.to.kafka.service;


import com.microservices.demo.ai.generated.tweet.to.kafka.service.config.AIGeneratedTweetToKafkaServiceConfigData;
import com.microservices.demo.ai.generated.tweet.to.kafka.service.init.StreamInitializer;
import com.microservices.demo.ai.generated.tweet.to.kafka.service.runner.AIStreamRunner;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.TaskScheduler;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * 1. Possible to use void init() method with @PostConstruct(instantiates after the Bean is created) + @Scope (default=Singleton)
 * Other scopes such as request instantiate a Bean whenever a request arrives (useful e.g. in a RestController).
 * 2. Possible to implement ApplicationListener -> overrides onApplicationEvent method.
 * 3. CHOSEN -> CommandLineRunner interface overriding run(). Different in the parameters
 */
@Slf4j
@SpringBootApplication
public class AIGeneratedTweetToKafkaServiceApplication implements CommandLineRunner {

//    This variable can be used implicitly with the @Slf4j annotation
//    private final Logger log = LoggerFactory.getLogger(AIGeneratedTweetToKafkaServiceApplication.class);

    private final AIGeneratedTweetToKafkaServiceConfigData configData;
    private final StreamInitializer streamInitializer;
    private final AIStreamRunner streamRunner;
    /**
     * Scheduling the job. We want to use the AIStreamRunner runnable class to set the timing.
     * New property added in the yaml and ...ConfigData class
     */
    private final TaskScheduler taskScheduler;

//    Constructor injection
    public AIGeneratedTweetToKafkaServiceApplication(AIGeneratedTweetToKafkaServiceConfigData configData,
                                                     StreamInitializer streamInitializer,
                                                     AIStreamRunner streamRunner,
                                                     @Qualifier("taskScheduler") TaskScheduler taskScheduler) {
        this.configData = configData;
        this.streamInitializer = streamInitializer;
        this.streamRunner = streamRunner;
        this.taskScheduler = taskScheduler;
    }

    public static void main(String[] args) {
        SpringApplication.run(AIGeneratedTweetToKafkaServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("Application is starting...");

        boolean initResult= streamInitializer.init();
        if(initResult) {
            taskScheduler.scheduleAtFixedRate(streamRunner, Duration.of(configData.getSchedulerDurationSec(), ChronoUnit.SECONDS));
            log.info("Keywords: {}", Arrays.toString(configData.getStreamingDataKeywords().toArray(new String[0])));
        } else {
            log.error("Stream initialization failed. Not starting the AI streaming runner");
        }
    }



}
