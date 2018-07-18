package com.leon.cloud;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.printf(title);

        driver.close();

    }
}
