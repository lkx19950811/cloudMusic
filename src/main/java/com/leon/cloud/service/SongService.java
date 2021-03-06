package com.leon.cloud.service;

import com.leon.cloud.common.BaseService;
import com.leon.cloud.entity.Song;
import com.leon.cloud.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leon
 * @date 2018-07-20 11:30
 * @desc
 */
@Service
public class SongService extends BaseService<Song> {
    @Autowired
    SongRepository repository;
}
