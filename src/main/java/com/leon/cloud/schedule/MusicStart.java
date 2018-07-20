package com.leon.cloud.schedule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author leon
 * @date 2018-07-19 15:40
 * @desc
 */
@Component
public class MusicStart {
    @Scheduled(cron = "0 0 0/12 * * ? ")
    public void getComment() throws InterruptedException {
        //      实例化ChromeDriver
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://music.163.com/");
        driver.findElementByLinkText("排行榜").click();
//      driver.close();

        driver.switchTo().frame("g_iframe");
        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement webElement : list){
            String href = webElement.getAttribute("href");
            if (StringUtils.isEmpty(href)){
                continue;
            }else if (!href.contains("toplist")){
                continue;
            }
            webElement.click();
            Thread.sleep(3000);
            break;
        }

    }
}
