package com.leon.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CloudApplication {

    public static void main(String[] args) {
        //注册谷歌驱动
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        SpringApplication.run(CloudApplication.class, args);
    }
}
