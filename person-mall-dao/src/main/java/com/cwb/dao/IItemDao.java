package com.cwb.dao;

import com.cwb.domain.po.Item;
import com.cwb.domain.res.PageReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @ClassName：IItemDao
 * @Author: caowenbo
 * @Date: 2025/3/22 21:40
 * @Description:
 */
@Mapper
public interface IItemDao {
     List<Item> getItemList (@RequestBody PageReq pageReq);


     List<Item> getItemListByKeyword(String name);

     Item getItemListById(String id);
}
