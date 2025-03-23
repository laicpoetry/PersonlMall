package com.cwb.controller;

import com.cwb.common.constants.Constants;
import com.cwb.common.response.Response;
import com.cwb.controller.dto.LoginFormDTO;
import com.cwb.domain.vo.UserLoginVO;
import com.cwb.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName：UserController
 * @Author: caowenbo
 * @Date: 2025/3/20 21:58
 * @Description: 用户操作
 */
@Slf4j
@RestController
@RequestMapping("/users/")
@CrossOrigin("*")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Response<UserLoginVO> login(@RequestBody @Validated LoginFormDTO loginFormDTO) {
        try {
            String userName = loginFormDTO.getUsername();
            String passWord = loginFormDTO.getPassword();
            UserLoginVO userLoginVO = userService.login(userName, passWord);
            log.info("用户登录 userLoginVO:{}", userLoginVO);
            return Response.<UserLoginVO>builder()
                    .code(Constants.ResponseCode.SUCCESS.getCode())
                    .info(Constants.ResponseCode.SUCCESS.getInfo())
                    .data(userLoginVO)
                    .build();
        } catch (Exception e) {
            log.info("用户登录失败", e);
            return Response.<UserLoginVO>builder()
                    .code(Constants.ResponseCode.UN_ERROR.getCode())
                    .info(Constants.ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }


}
