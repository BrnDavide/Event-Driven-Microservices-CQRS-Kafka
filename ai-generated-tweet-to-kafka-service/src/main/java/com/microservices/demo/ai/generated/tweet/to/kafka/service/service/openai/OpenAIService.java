package com.microservices.demo.ai.generated.tweet.to.kafka.service.service.openai;

import com.microservices.demo.ai.generated.tweet.to.kafka.service.exception.AIGeneratedTweetToKafkaServiceException;
import com.microservices.demo.ai.generated.tweet.to.kafka.service.service.AIService;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService implements AIService {
    @Override
    public String generateTweet() throws AIGeneratedTweetToKafkaServiceException {
        return "Ai generated tweet content";
    }
}
