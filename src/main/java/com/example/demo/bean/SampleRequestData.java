package com.example.demo.bean;

import lombok.Data;

@Data
public class SampleRequestData {
    private String title;
    private String text;

    public SampleRequestData(String title, String text) {
        this.title = title;
        this.text = text;
    }

}
