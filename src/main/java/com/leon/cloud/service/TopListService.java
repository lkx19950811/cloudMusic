package com.leon.cloud.service;

import com.leon.cloud.common.BaseService;
import com.leon.cloud.common.Constants;
import com.leon.cloud.entity.Singer;
import com.leon.cloud.entity.Toplist;
import com.leon.cloud.repository.SingerRepository;
import com.leon.cloud.repository.SongRepository;
import com.leon.cloud.repository.TopListRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author leon
 * @date 2018-07-20 11:30
 * @desc
 */
@Service
public class TopListService extends BaseService<Toplist> {
    Logger logger = LoggerFactory.getLogger(TopListService.class);
    @Autowired
    TopListRepository repository;
    @Autowired
    SongRepository songRepository;
    @Autowired
    SingerRepository singerRepository;
    public void parseTop(List<String> urls,ChromeDriver driver){
        List<Toplist> toplists = new ArrayList<>();
        urls.stream().forEach(currUrl->{
            driver.get(currUrl);
            driver.switchTo().frame("g_iframe");
            List<WebElement> webElements = driver.findElements(By.tagName("tr"));//一首歌包含在一个tr中
            webElements.stream().forEach(e -> {
                String rank;
                try {
                    rank = e.findElement(By.className("num")).getText();
                }catch (Exception ex){
                    rank = null;
                }
                if (rank!=null){
                    Toplist toplist = new Toplist();
                    String songName = e.findElement(By.tagName("b")).getAttribute("title");//歌曲名字
                    List<WebElement> as = e.findElements(By.tagName("a"));//a标签们 上面有各种链接
                    as.forEach(a->{
                        String hrefurl = a.getAttribute("href");
                        if (hrefurl.contains("song")){
                            toplist.setUrl(hrefurl);
                        }else if (hrefurl.contains("artist")){
                            //先看看是否存在该歌手
                            String singname = a.getText().replaceAll("\\n","");
                            Optional<Singer> optionalSinger = Optional.ofNullable(singerRepository.findByName(singname));
                            if (optionalSinger.isPresent()){//存入歌手
                                toplist.setSinger(optionalSinger.get());
                            }else {
                                Singer singer = new Singer();
                                singer.setName(singname);
                                singer.setUrl(hrefurl);
                                toplist.setSinger(singerRepository.save(singer));
                            }
                        }
                    });
                    String time = e.findElement(By.className("u-dur")).getText();//歌曲时长
                    toplist.setRank(Integer.valueOf(rank));
                    toplist.setSongName(songName);
                    toplist.setTopName(driver.getTitle());
                    toplist.setTime(time);
                    toplists.add(toplist);
                }
            });
        });
        repository.saveAll(toplists);
        logger.info("总共保存歌曲{}",toplists.size());
    }
}
