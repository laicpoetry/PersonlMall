package com.cwb.domain.po;

import com.cwb.domain.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @ClassName：User
 * @Author: caowenbo
 * @Date: 2025/3/21 13:17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码，加密存储
     */
    private String passWord;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 使用状态（1正常 2冻结）
     */
    private int status;

    /**
     * 账户余额
     */
    private BigDecimal balance;
}
