package com.viego.financialrecommendsystem.service;

import com.viego.financialrecommendsystem.entity.Comment;
import com.viego.financialrecommendsystem.entity.Discuss;

import java.util.List;

public interface IDiscussService {
    /**
     * 根据 id 进行查询
     */
    Discuss queryById(Long discussId);

    List<Comment> comment(long parseLong);
}
