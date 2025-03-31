package com.cwb.service;

import com.cwb.domain.po.Cart;
import com.cwb.domain.vo.CartFormVO;

import java.util.List;

/**
 * @ClassName：ICartService
 * @Author: caowenbo
 * @Date: 2025/3/31 21:41
 * @Description:
 */
public interface ICartService {

    void addItem2Cart(CartFormVO cartFormVO);

    List<Cart> queryMyCarts();
}
