package com.leon.cloud.service;

import com.leon.cloud.common.BaseService;
import com.leon.cloud.common.Constants;
import com.leon.cloud.entity.Record;
import com.leon.cloud.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon
 * @date 2018-07-20 13:30
 * @desc
 */
@Service
public class RecordService extends BaseService<Record> {
    @Autowired
    RecordRepository repository;

    /**
     * 初始化爬取链接
     * @return
     */
    public List<Record> initRecords(){
        List<Record> lists = new ArrayList<>();
        if (repository.count()==0){
            //开始初始化表
            Record record = new Record();
            record.setUrl(Constants.musicUrl);
            repository.save(record);
            lists.add(record);
        }else {
            lists.addAll(repository.findAllByUsed("0"));
        }
        return lists;
    }
}
