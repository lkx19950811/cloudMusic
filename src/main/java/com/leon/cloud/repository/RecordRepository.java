package com.leon.cloud.repository;

import com.leon.cloud.common.Repository;
import com.leon.cloud.entity.Record;

import java.util.List;

/**
 * @author leon
 * @date 2018-07-20 13:31
 * @desc
 */
public interface RecordRepository extends Repository<Record> {
    /**
     * 寻找used等于?
     * @param used
     * @return
     */
    List<Record> findAllByUsed(String used);
}
