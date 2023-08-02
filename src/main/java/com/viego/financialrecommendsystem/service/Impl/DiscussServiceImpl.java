package com.viego.financialrecommendsystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.viego.financialrecommendsystem.entity.Comment;
import com.viego.financialrecommendsystem.entity.Discuss;
import com.viego.financialrecommendsystem.mapper.CommentMapper;
import com.viego.financialrecommendsystem.mapper.DiscussMapper;
import com.viego.financialrecommendsystem.service.IDiscussService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.CookieManager;
import java.util.List;

@Service
public class DiscussServiceImpl implements IDiscussService {

    @Resource
    DiscussMapper discussMapper;

    @Resource
    CommentMapper commentMapper;

    @Override
    public Discuss queryById(Long discussId) {
        return discussMapper.selectById(discussId);
    }

    @Override
    public List<Comment> comment(long parseLong) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getDiscussId,parseLong);
        return commentMapper.selectList(queryWrapper);
    }
}
