package com.cwb.dao;

import com.cwb.domain.po.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @ClassName：ICartDao
 * @Author: caowenbo
 * @Date: 2025/3/31 21:53
 * @Description:
 */
@Mapper
public interface ICartDao {

    int selectByItemIdAndUserId(Long itemId,Long userId);

    void updateNum(Long itemId, Long userId);

    int countByUserId(Long userId);

    void insert(Cart cart);

    List<Cart> selectByUserId(Long userId);
}
