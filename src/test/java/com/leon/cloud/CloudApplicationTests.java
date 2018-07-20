package com.leon.cloud;

import com.leon.cloud.schedule.MusicStart;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudApplicationTests {
    @Before
    public void register(){
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");//注册谷歌的驱动
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
    }
    @Test
    public void contextLoads() throws InterruptedException {
        MusicStart musicStart = new MusicStart();
        musicStart.getTopList();
    }

}
