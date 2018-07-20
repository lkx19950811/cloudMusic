package com.leon.cloud.service;

import com.leon.cloud.common.BaseService;
import com.leon.cloud.entity.Comment;
import com.leon.cloud.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leon
 * @date 2018-07-20 11:30
 * @desc
 */
@Service
public class CommentService extends BaseService<Comment> {
    @Autowired
    CommentRepository repository;
}
