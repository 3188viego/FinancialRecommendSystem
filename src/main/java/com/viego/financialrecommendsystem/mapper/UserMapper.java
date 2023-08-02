package com.viego.financialrecommendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viego.financialrecommendsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户登录方法
     * @param user 用户对应的实体类对象
     * @return 在数据库搜索之后的登录用户的实体类对象
     */
    User login(User user);

    /**
     * 根据 uid 获取资产
     * @param userId 用户的 id
     * @return 用户的资产
     */
    Integer getassets(Long userId);

}
