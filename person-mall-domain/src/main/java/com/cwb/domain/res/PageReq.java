package com.cwb.domain.res;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @ClassName：PageReq
 * @Author: caowenbo
 * @Date: 2025/3/21 22:17
 * @Description:
 */
@Data
public class PageReq {
    public static final Integer DEFAULT_PAGE_SIZE = 20;
    public static final Integer DEFAULT_PAGE_NUM = 1;

    @Min(value = 1, message = "页码不能小于1")
    private Integer pageNo = DEFAULT_PAGE_NUM;

    @Min(value = 1, message = "每页查询数量不能小于1")
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    //偏移量
    private Integer offset;

    //是否升序
    private Boolean isAsc = true;

    //排序方式
    private String sortBy;

    //最后一次更新时间
    private String lastUpdateTime;

}
