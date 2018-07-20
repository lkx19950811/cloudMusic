package com.leon.cloud.repository;

import com.leon.cloud.common.Repository;
import com.leon.cloud.entity.Singer;

/**
 * @author leon
 * @date 2018-07-20 17:10
 * @desc
 */
public interface SingerRepository extends Repository<Singer> {
    /**
     * 按照名字找歌手
     * @param name
     * @return
     */
    Singer findByName(String name);
}
