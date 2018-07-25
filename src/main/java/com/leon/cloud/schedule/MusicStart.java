package com.leon.cloud.schedule;

import com.leon.cloud.common.Constants;
import com.leon.cloud.entity.Toplist;
import com.leon.cloud.service.CommentService;
import com.leon.cloud.service.SongService;
import com.leon.cloud.service.TopListService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon
 * @date 2018-07-19 15:40
 * @desc
 */
@Component
public class MusicStart {
    @Autowired
    CommentService commentService;
    @Autowired
    SongService songService;
    @Autowired
    TopListService topListService;
//    @Scheduled(cron = "0 0 0/12 * * ? ")
    @Scheduled(initialDelay = 1000, fixedRate = 1000 * 60 * 60 * 24)   //initialDelay = 1000表示延迟1000ms执行第一次任务
    public void Music() throws InterruptedException {
        getTopList();
    }

    public void getTopList() throws InterruptedException {
        //      实例化ChromeDriver
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://music.163.com/");
        driver.findElementByLinkText("排行榜").click();
//      driver.close();

        driver.switchTo().frame("g_iframe");
        List<WebElement> list = driver.findElements(By.className("avatar"));
        List<String> topUrls = new ArrayList<>();
        for (WebElement webElement : list){
            String href = webElement.getAttribute("href");
            if (StringUtils.isEmpty(href)){
                continue;
            }else if (!href.contains("toplist")){
                continue;
            }
            topUrls.add(href);
        }
        topListService.parseTop(topUrls,driver);
        driver.close();

    }
}
