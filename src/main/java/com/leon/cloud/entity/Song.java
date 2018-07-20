package com.leon.cloud.entity;

import com.leon.cloud.common.Domain;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author leon
 * @date 2018-07-19 17:10
 * @desc
 */
@Entity
@Data
public class Song extends Domain {
    /**
     * 歌曲名字
     */
    private String songName;
    /**
     * 歌手
     */
    private String singer;
    /**
     * 作词
     */
    private String author;
    /**
     * 作曲
     */
    private String composer;
    /**
     * 所属专辑
     */
    private String album;
    /**
     * 评论数
     */
    private Integer reviewQuantity;
}
