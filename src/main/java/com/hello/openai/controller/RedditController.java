package com.hello.openai.controller;

import com.hello.openai.service.RedditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/reddit")
@RestController
public class RedditController {

    private final RedditService redditService;

    @GetMapping
    public String getAccessToken() {
        return redditService.getRedditAccessToken();
    }
}
