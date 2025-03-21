package com.cwb.service.impl;

import com.cwb.common.exception.BadRequestException;
import com.cwb.common.exception.ForbiddenException;
import com.cwb.dao.IUserDao;
import com.cwb.domain.enums.UserStatus;
import com.cwb.domain.po.User;
import com.cwb.domain.vo.UserLoginVO;
import com.cwb.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @ClassName：UserServiceImpl
 * @Author: caowenbo
 * @Date: 2025/3/20 22:49
 * @Description:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public UserLoginVO login(String userName, String passWord) {

        User loginUser = userDao.getUserByUserName(userName);
        Assert.notNull(loginUser, "用户名错误");
        // 3.校验是否禁用
        if (loginUser.getStatus() == UserStatus.FROZEN.getValue()) {
            throw new ForbiddenException("用户被冻结");
        }
        // 4.校验密码
        /*if (!passwordEncoder.matches(passWord, loginUser.getPassWord())) {
            throw new BadRequestException("用户名或密码错误");
        }*/
        // 5.生成TOKEN
        // String token = jwtTool.createToken(loginUser.getId(), jwtProperties.getTokenTTL());
        // 6.封装VO返回
        UserLoginVO vo = new UserLoginVO();
        vo.setUserId(loginUser.getId());
        vo.setUsername(loginUser.getUserName());
        vo.setBalance(loginUser.getBalance());
        vo.setToken("");
        return vo;
    }
}
