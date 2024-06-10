package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCaller {

    public static void main(String[] args) throws IOException {
        // API Endpoint
        String apiUrl = "http://localhost:8080/api/store/get?id=1";

        // 创建URL对象
        URL url = new URL(apiUrl);

        // 创建HttpURLConnection对象
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置请求方法
        connection.setRequestMethod("GET");

        // 设置请求头
        connection.setRequestProperty("Content-Type", "application/json");

        // 发起请求
        int responseCode = connection.getResponseCode();

        // 读取响应内容
        BufferedReader reader;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        // 读取响应内容
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // 打印响应内容
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Body: " + response.toString());

        // 关闭连接
        connection.disconnect();
    }
}
