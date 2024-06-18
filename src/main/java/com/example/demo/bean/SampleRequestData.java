package com.example.demo.bean;

import lombok.Data;

import java.util.List;

@Data
public class SampleRequestData {
    private String title;
    private String text;
    private List<String> list;

    public SampleRequestData(String title, String text, List<String> list) {
        this.title = title;
        this.text = text;
        this.list = list;
    }

}
