package com.cwb.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName：Response
 * @Author: caowenbo
 * @Date: 2025/3/20 23:07
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private static final long serialVersionUID = 7000723935764546321L;

    private String code;
    private String info;
    private T data;
}
