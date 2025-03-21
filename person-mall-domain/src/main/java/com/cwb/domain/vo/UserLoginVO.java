package com.cwb.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName：UserLoginVO
 * @Author: caowenbo
 * @Date: 2025/3/20 22:54
 * @Description:
 */
@Data
public class UserLoginVO {
    private String token;
    private Long userId;
    private String username;
    private BigDecimal balance;
}
