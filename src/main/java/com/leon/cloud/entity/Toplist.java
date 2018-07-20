package com.leon.cloud.entity;

import com.leon.cloud.common.Domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

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
    @OneToOne
    private Song song;
    /**
     * 排名
     */
    private Integer rank;
}
