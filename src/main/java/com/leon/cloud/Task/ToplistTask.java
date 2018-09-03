package com.leon.cloud.Task;

import com.leon.cloud.service.TopListService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author lee Cather
 * @date 2018-09-03 16:08
 * desc : 排行榜任务
 */
@Component
public class ToplistTask implements Callable<String> {
    private Logger logger = LoggerFactory.getLogger(ToplistTask.class);
    @Autowired
    TopListService topListService;
    @Override
    public String call() throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String start = sf.format(new Date());
        logger.info("start:{} ",start);
        //      实例化ChromeDriver
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://music.163.com/");
        driver.findElementByLinkText("排行榜").click();
//      driver.close();

        driver.switchTo().frame("g_iframe");
        List<WebElement> list = driver.findElements(By.className("avatar"));
        List<String> topUrls = new ArrayList<>();
        list.forEach(webElement->{
            String href = webElement.getAttribute("href");
            if (!StringUtils.isEmpty(href) && (href.contains("toplist"))){
                topUrls.add(href);
            }
        });
        topListService.parseTop(topUrls,driver);
        driver.close();
        String end = sf.format(new Date());
        logger.info("start: {} ---- end:{}",start,end);
        return "start :" + start + " -----  end: " + end;
    }
}
