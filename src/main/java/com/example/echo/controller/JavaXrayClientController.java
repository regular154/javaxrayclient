package com.example.echo.controller;

import com.amazonaws.xray.AWSXRay;
import com.example.echo.client.JavaXrayClientClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;


@RestController
@Slf4j
@RequiredArgsConstructor
public class JavaXrayClientController {

    private JavaXrayClientClient client;

    @GetMapping("/echo")
    public ResponseEntity<Object> get(@RequestBody(required = false) Object requestDto) {
        log.info("Enter GET /echo endpoint");
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

    @PutMapping("/echo")
    public ResponseEntity<Object> put(@RequestBody(required = false) Object requestDto) {
        log.info("Enter PUT /echo endpoint");
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

    @GetMapping("/ip")
    public ResponseEntity<String> getIp() throws UnknownHostException {
        log.info("Enter GET /ip endpoint");
        return new ResponseEntity<>(InetAddress.getLocalHost().getHostAddress(), HttpStatus.OK);
    }

    @PostMapping("/pass")
    public ResponseEntity<String> pass() {
        log.info("Enter POST /pass endpoint");
        Objects.requireNonNull(AWSXRay.getCurrentSegment()).setUser("userId123");
        return new ResponseEntity<>(client.pass(), HttpStatus.OK);
    }
}
