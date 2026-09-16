package com.microservices.demo.ai.generated.tweet.to.kafka.service.runner;

import com.microservices.demo.ai.generated.tweet.to.kafka.service.service.AIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
/**
 * Calling AI services to generate content coninuously
 */
public class AIStreamRunner implements Runnable {


    private final AIService service;

    public AIStreamRunner(AIService service) {
        this.service = service;
    }

    @Override
    public void run() {
        String generatedTweet = service.generateTweet();
        log.info("Generated Tweet: "+ generatedTweet);

    }
}
