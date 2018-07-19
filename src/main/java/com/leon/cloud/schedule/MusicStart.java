package com.leon.cloud.schedule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author leon
 * @date 2018-07-19 15:40
 * @desc
 */
@Component
public class MusicStart {
    @Scheduled(cron = "0 0 0/12 * * ? ")
    public void getComment(){
//        实例化ChromeDriver
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://music.163.com/");
        driver.findElementByLinkText("歌手").click();
//      driver.close();

        driver.switchTo().frame("g_iframe");
//        driver.findElementByClassName("u-btni-addply").click();
        List<WebElement> list = driver.findElements(By.tagName("a"));
    }
}
