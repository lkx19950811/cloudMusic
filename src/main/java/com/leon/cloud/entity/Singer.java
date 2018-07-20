package com.leon.cloud.entity;

import com.leon.cloud.common.Domain;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author leon
 * @date 2018-07-20 17:01
 * @desc 歌手
 */
@Entity
@Data
public class Singer extends Domain {
    /**
     * 歌手名字
     */
    private String name;
    /**
     * 歌手主页地址
     */
    private String url;
}
