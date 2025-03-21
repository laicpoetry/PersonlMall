package com.cwb.dao;

import com.cwb.domain.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName：IUserDao
 * @Author: caowenbo
 * @Date: 2025/3/21 13:22
 * @Description:
 */
@Mapper
public interface IUserDao {
    User getUserByUserName(String userName);
}
