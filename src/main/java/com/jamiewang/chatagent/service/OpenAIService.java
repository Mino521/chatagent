package com.jamiewang.chatagent.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class OpenAIService {
    @Value("${ai.api-key}")
    private String apiKey;

    @Value("${ai.model}")
    private String model;

    private ChatLanguageModel chatModel;

    @PostConstruct
    public void init() {
        chatModel = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName(model)
                .temperature(0.7)
                .build();
    }

    public String chat(String userInput) {
        return chatModel.generate(userInput);
    }
}
