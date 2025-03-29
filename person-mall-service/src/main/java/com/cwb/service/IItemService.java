package com.cwb.service;

import com.cwb.domain.po.Item;
import com.cwb.domain.res.PageReq;

import java.util.List;

/**
 * @ClassName：IItemService
 * @Author: caowenbo
 * @Date: 2025/3/22 21:27
 * @Description:
 */
public interface IItemService {
    List<Item> getItemList(PageReq query);

    List<Item> getItemListByKeyword(String name);

    Item getItemListById(String id);
}
