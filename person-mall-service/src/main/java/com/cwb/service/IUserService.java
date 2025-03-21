package com.cwb.service;

import com.cwb.domain.vo.UserLoginVO;


/**
 * @ClassName：IUserService
 * @Author: caowenbo
 * @Date: 2025/3/20 22:48
 * @Description:
 */

public interface IUserService {
     UserLoginVO login(String userName, String passWord);
}
