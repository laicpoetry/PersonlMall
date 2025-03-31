package com.cwb.listener;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName：OrderPaySuccessListener
 * @Author: caowenbo
 * @Date: 2025/2/16 15:47
 * @Description:
 */
@Slf4j
@Component
public class OrderPaySuccessListener {
    @Subscribe
    public void handleEvent(String paySuccessEvent){
        log.info("收到支付成功消息，可以做接下来的事情，如：发货、充值、开会员、返利",paySuccessEvent);
    }
}
