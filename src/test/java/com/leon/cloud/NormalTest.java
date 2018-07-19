package com.leon.cloud;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.StringUtils;

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
    public void hello(){
//        实例化ChromeDriver
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://music.163.com/");
        driver.findElementByLinkText("排行榜").click();
//        driver.close();

        driver.switchTo().frame("g_iframe");
        driver.findElementByClassName("u-btni-addply").click();

    }
}
