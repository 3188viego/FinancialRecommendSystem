package com.viego.financialrecommendsystem.service;

import com.viego.financialrecommendsystem.entity.AccessRecord;
import com.viego.financialrecommendsystem.entity.User;

import java.util.List;

public interface IUserService {
    /**
     * 用户登录的业务
     * @param user 用户实体对象
     * @return 从数据库中查取一个用户对象 username 和 password 都各自对应
     */
    User login(User user);

    /**
     * 根据uid获取资产
     * @param userId 用户的id
     * @return 资产
     */
    Integer getassets(Long userId);

    boolean addRecord(List<AccessRecord> list);
}
