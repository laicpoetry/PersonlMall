package com.cwb.dao;

import com.cwb.domain.po.PayOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName：IOrderDao
 * @Author: caowenbo
 * @Date: 2025/3/30 21:30
 * @Description:
 */
@Mapper
public interface IOrderDao {

    PayOrder queryUnPayOrder(PayOrder payOrderReq);

    void updateOrderPayInfo(PayOrder payOrder);

    void insert(PayOrder build);

    void changeOrderPaySuccess(PayOrder payOrderReq);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);
}
