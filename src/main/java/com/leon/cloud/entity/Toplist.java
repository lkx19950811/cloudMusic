package com.leon.cloud.entity;

import com.leon.cloud.common.Domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
/**
 * @author leon
 * @date 2018-07-20 11:11
 * @desc 排行榜
 */
@Data
@Entity
public class Toplist extends Domain {
    /**
     * 排行榜的名称
     */
    private String topName;
    /**
     * 歌曲
     */
    private String songName;
    /**
     * 排名
     */
    private Integer rank;
    /**
     * 歌曲链接
     */
    private String url;
    /**
     * 歌手
     */
    @ManyToOne
    private Singer singer;
    /**
     * 时长
     */
    private String time;
}
