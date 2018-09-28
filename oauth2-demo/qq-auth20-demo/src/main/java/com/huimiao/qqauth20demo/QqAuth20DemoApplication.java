package com.huimiao.qqauth20demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QqAuth20DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QqAuth20DemoApplication.class, args);
    }

    @GetMapping("/prod")
    public String getProductionName() {
        return "name";
    }
}
