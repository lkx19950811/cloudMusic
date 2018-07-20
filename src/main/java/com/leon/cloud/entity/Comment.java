package com.leon.cloud.entity;

import com.leon.cloud.common.Domain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author leon
 * @date 2018-07-20 11:16
 * @desc 评论
 */
@Entity
@Data
public class Comment extends Domain {
    /**
     * 用户
     */
    private String user;
    /**
     * 评论内容
     */
    @Column(length = 1000)
    private String commnetText;
    /**
     * 点赞数
     */
    private Integer vote;
}
