package com.viego.financialrecommendsystem.service.Impl;

import com.viego.financialrecommendsystem.entity.AccessRecord;
import com.viego.financialrecommendsystem.entity.User;
import com.viego.financialrecommendsystem.mapper.AccessRecordMapper;
import com.viego.financialrecommendsystem.mapper.UserMapper;
import com.viego.financialrecommendsystem.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    //这是用户的 mapper
    @Resource
    UserMapper userMapper;

    //这是访问记录对象的 mapper
    @Resource
    AccessRecordMapper accessRecordMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }


    @Override
    public Integer getassets(Long userId) {
        return userMapper.getassets(userId);
    }

    @Override
    public boolean addRecord(List<AccessRecord> list) {
        return accessRecordMapper.insertList(list) == list.size();
    }
}
