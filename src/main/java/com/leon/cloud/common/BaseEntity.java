package com.leon.cloud.common;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author leon
 * @date 2018-07-19 17:13
 * @desc
 */
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    private Integer id;
    private Date createDate = new Date();
}
