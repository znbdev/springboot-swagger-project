package com.example.demo.controller;

import com.example.demo.bean.SampleRequestData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RequiredArgsConstructor
@Slf4j
@RestController
@Api(tags = "First API")
@RequestMapping("/api/first")
public class FirstController {
    private final MessageSource messageSource;

    @ApiOperation(value = "Get method in the first API")
    @GetMapping("/get")
    public String getFirstApi() {
        log.info("This is the first API");
        log.info(messageSource.getMessage("api.name", null, Locale.getDefault()));
        log.info(messageSource.getMessage("api.name", null, Locale.CHINA));
        log.info(messageSource.getMessage("api.name", null, Locale.JAPAN));
        log.info(messageSource.getMessage("api.name", null, Locale.US));
        return "This is the first API";
    }

    @CrossOrigin(origins = "*")
    @ApiOperation("OkHttp Post Test")
    @PostMapping("/okHttpPostTest")
    public SampleRequestData okHttpPostTest(@RequestBody SampleRequestData requestData) {
        log.info(requestData.getTitle());
        log.info(requestData.getText());
        return new SampleRequestData(requestData.getText(), requestData.getTitle());
    }
}
