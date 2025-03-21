package com.cwb.domain.enums;

import com.cwb.common.exception.BadRequestException;
import lombok.Getter;

@Getter
public enum UserStatus {
    FROZEN(0, "禁止使用"),
    NORMAL(1, "已激活"),
    ;
    int value;
    String desc;

    UserStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static UserStatus of(int value) {
        if (value == 0) {
            return FROZEN;
        }
        if (value == 1) {
            return NORMAL;
        }
        throw new BadRequestException("账户状态错误");
    }
}