package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@Api(tags = "Second API")
@RequestMapping("/api/second")
public class SecondController {

    @ApiOperation(value = "Get method in the second API")
    @GetMapping("/get")
    public String getSecondApi() {
        log.info("This is the second API");
        return "This is the second API";
    }
}
