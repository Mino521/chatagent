package com.jamiewang.chatagent.controller;

import com.jamiewang.chatagent.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
@RequestMapping("/api/ai")
public class AIController {

    @Value("${ai.api-key}")
    private String apiKey;

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(name = "text") String text) {
        System.out.println(apiKey);
        String summary = openAIService.chat(text);
        return ResponseEntity.ok(summary);
    }
}
