package com.cwb.service;

import com.cwb.domain.req.ShopCartReq;
import com.cwb.domain.res.PayOrderRes;

import java.util.List;

/**
 * @ClassName：IOrderService
 * @Author: caowenbo
 * @Date: 2025/3/30 21:25
 * @Description:
 */
public interface IOrderService {
    PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception;

    void changeOrderPaySuccess(String orderId);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);
}
