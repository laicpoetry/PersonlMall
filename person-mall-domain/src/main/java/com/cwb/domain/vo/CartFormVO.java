package com.cwb.domain.vo;

import lombok.Data;

@Data
public class CartFormVO {
    private Long itemId;
    private String name;
    private String spec;
    private Integer price;
    private String image;
}
