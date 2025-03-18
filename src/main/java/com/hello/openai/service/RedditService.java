package com.hello.openai.service;

import com.hello.openai.client.RedditClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class RedditService {

    private final RedditClient redditClient;

    @Value("${reddit.client.id}")
    private String clientId;

    @Value("${reddit.client.secret}")
    private String clientSecret;

    @Value("${reddit.username}")
    private String username;

    @Value("${reddit.password}")
    private String password;

    public String getRedditAccessToken() {

        String credentials = clientId + ":" + clientSecret;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + encodedCredentials;

        Map<String, Object> response = redditClient.getAccessToken(
                authHeader,
                "password",
                username,
                password
        );

        return (String) response.get("access_token");
    }


}
