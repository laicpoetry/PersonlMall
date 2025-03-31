package com.cwb.domain.po;


import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车条目id 
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * sku商品id
     */
    private Long itemId;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 商品标题
     */
    private String name;

    /**
     * 商品动态属性键值集
     */
    private String spec;

    /**
     * 价格,单位：分
     */
    private Integer price;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
