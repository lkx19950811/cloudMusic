package com.leon.cloud.entity;

import com.leon.cloud.common.Domain;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author leon
 * @date 2018-07-20 11:52
 * @desc
 */
@Data
@Entity
public class Record extends Domain {
    /**
     * url
     */
    private String url;
    /**
     * 是否使用过 1为使用过 0为未使用
     */
    private String used = "0";
}
