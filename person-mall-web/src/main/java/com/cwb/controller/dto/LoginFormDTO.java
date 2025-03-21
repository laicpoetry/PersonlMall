package com.cwb.controller.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @ClassName：LoginFormDTO
 * @Author: caowenbo
 * @Date: 2025/3/20 22:42
 * @Description:
 */
@Data
public class LoginFormDTO {

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

    private Boolean rememberMe = false;
}
