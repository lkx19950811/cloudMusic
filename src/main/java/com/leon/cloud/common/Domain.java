package com.leon.cloud.common;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author leon
 * @date 2018-07-19 17:13
 * @desc
 */
@Data
@MappedSuperclass
public class Domain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();
}
