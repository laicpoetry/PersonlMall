package com.cwb.service.impl;

import cn.hutool.core.util.StrUtil;
import com.cwb.common.exception.BizIllegalException;
import com.cwb.dao.ICartDao;
import com.cwb.domain.po.Cart;
import com.cwb.domain.vo.CartFormVO;
import com.cwb.service.ICartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName：CartServiceImpl
 * @Author: caowenbo
 * @Date: 2025/3/31 21:50
 * @Description:
 */
@Service
public class CartServiceImpl implements ICartService {
    @Resource
    private ICartDao cartDao;

    @Override
    public void addItem2Cart(CartFormVO cartFormVO) {
        // 1.获取登录用户
        //Long userId = UserContext.getUser();
        Long userId = 1L;
        // 2.判断是否已经存在
        if (checkItemExists(cartFormVO.getItemId(), userId)) {
            // 2.1.存在，则更新数量
            cartDao.updateNum(cartFormVO.getItemId(), userId);
            return;
        }
        // 2.2.不存在，判断是否超过购物车数量
        checkCartsFull(userId);

        // 3.新增购物车条目
        // 3.1.转换PO
        Cart cart = Cart.builder()
                .price(cartFormVO.getPrice())
                .image(cartFormVO.getImage())
                .spec(cartFormVO.getSpec())
                .name(cartFormVO.getName())
                .itemId(cartFormVO.getItemId())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        // 3.2.保存当前用户
        cart.setUserId(userId);
        // 3.3.保存到数据库
        cartDao.insert(cart);
    }

    @Override
    public List<Cart> queryMyCarts() {
        Long userId = 1L;
        return cartDao.selectByUserId(userId);
    }


    private void checkCartsFull(Long userId) {
        int count = cartDao.countByUserId(userId);
        if (count >= 10) {
            throw new BizIllegalException(StrUtil.format("用户购物车课程不能超过{}", 10));
        }
    }

    private boolean checkItemExists(Long itemId, Long userId) {
        int count = cartDao.selectByItemIdAndUserId(itemId, userId);
        return count > 0;
    }
}
