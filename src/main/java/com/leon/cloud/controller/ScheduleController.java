package com.leon.cloud.controller;

import com.leon.cloud.Task.ToplistTask;
import com.leon.cloud.service.TopListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author lee Cather
 * @date 2018-09-03 15:55
 * desc : 定时任务的controller
 */
@RestController
public class ScheduleController  {
    private Logger logger = LoggerFactory.getLogger(ScheduleController.class);
    final
    ToplistTask toplistTask;
    private ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(16);

    @Autowired
    public ScheduleController(ToplistTask toplistTask) {
        this.toplistTask = toplistTask;
    }

    @RequestMapping("/delay")
    public String delayTask(Integer second) throws InterruptedException {
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String start = sf.format(new Date());
        logger.info("requestTime:{} ",start);
        executor.schedule(toplistTask,second,TimeUnit.SECONDS);
        return "任务已执行,请稍等" + second + "秒";
    }
}
