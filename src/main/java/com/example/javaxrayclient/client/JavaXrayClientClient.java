package com.example.javaxrayclient.client;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@XRayEnabled
public class JavaXrayClientClient {

    @Value("${xray.server.url}")
    private String url;

    private final WebClient client = WebClient.builder()
            .baseUrl(url)
            .build();

    public String pass() {
        return client.get()
                .uri("/ip")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
