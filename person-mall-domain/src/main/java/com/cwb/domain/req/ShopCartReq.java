package com.cwb.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName：ShopCartReq
 * @Author: caowenbo
 * @Date: 2025/2/12 14:52
 * @Description: 购物车
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopCartReq {
    private String userId;

    private String productId;
}
