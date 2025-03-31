package com.cwb.domain.res;

import com.cwb.common.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName：PayOrderRes
 * @Author: caowenbo
 * @Date: 2025/2/12 14:52
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayOrderRes {
    private String userId;

    private String orderId;

    private String payUrl;

    private Constants.OrderStatusEnum orderStatusEnum;
}
