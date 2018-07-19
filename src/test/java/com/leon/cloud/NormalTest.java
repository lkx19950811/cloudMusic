package com.leon.cloud;

import com.leon.cloud.entity.Song;
import org.hibernate.validator.constraints.EAN;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.StringUtils;

import javax.persistence.Temporal;
import java.util.List;


/**
 * @author leon
 * @date 2018-07-18 09:31
 * @desc
 */
public class NormalTest {
    @Before
    public void register(){
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");//注册谷歌的驱动
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
    }
    @Test
    public void runMusic() throws InterruptedException {
//        实例化ChromeDriver
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://music.163.com/");
        driver.findElementByLinkText("歌手").click();
//      driver.close();

        driver.switchTo().frame("g_iframe");
//        driver.findElementByClassName("u-btni-addply").click();
        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement webElement : list){
            String href = webElement.getAttribute("href");
            if (StringUtils.isEmpty(href)){
                continue;
            }else if (!href.contains("song")){
                continue;
            }
            webElement.click();
            Thread.sleep(3000);
        }
    }
    @Test
    public void testGetSet(){
        Song song = new Song();
        System.out.println(song);
    }
}
