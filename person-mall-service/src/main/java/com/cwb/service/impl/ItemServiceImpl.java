package com.cwb.service.impl;

import com.cwb.dao.IItemDao;
import com.cwb.domain.po.Item;
import com.cwb.domain.res.PageReq;
import com.cwb.service.IItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName：ItemServiceImpl
 * @Author: caowenbo
 * @Date: 2025/3/22 21:36
 * @Description:
 */
@Slf4j
@Service
public class ItemServiceImpl implements IItemService {
    @Resource
    private IItemDao iItemDao;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    private static final int REDIS_EXPIRE_TIME = 24 * 3600;
    private static final String LAST_UPDATE_TIME_KEY_PREFIX = "lastUpdateTime:page:";

    /**
     * 分页获取商品列表
     */
    @Override
    public List<Item> getItemList(PageReq query) {

        // 计算偏移量
        calculateOffset(query);
        // 设置排序规则
        setSortingOrder(query);

        String lastUpdateTimeKey = LAST_UPDATE_TIME_KEY_PREFIX + query.getPageNo();
        String lastUpdateTime = getLastUpdateTimeFromRedis(lastUpdateTimeKey);

        if (lastUpdateTime != null) {
            query.setLastUpdateTime(lastUpdateTime);
            // 存在最后更新时间则不需要偏移量
            query.setOffset(0);
        }

        List<Item> itemList = iItemDao.getItemList(query);

        if (!itemList.isEmpty()) {
            lastUpdateTime = itemList.get(itemList.size() - 1).getUpdateTime();
            // 获取的时间是用于下一页查询的
            lastUpdateTimeKey = LAST_UPDATE_TIME_KEY_PREFIX + (query.getPageNo() + 1);
            saveLastUpdateTimeToRedis(lastUpdateTimeKey, lastUpdateTime);
        }

        return itemList;
    }

    /**
     * 搜索商品
     */
    //todo  可优化
    @Override
    public List<Item> getItemListByKeyword(String name) {
        return iItemDao.getItemListByKeyword(name);
    }

    /**
     * 根据商品id查询 用于商品详情页
     */
    @Override
    public Item getItemListById(String id) {
        return iItemDao.getItemListById(id);
    }

    private void setSortingOrder(PageReq query) {
        query.setSortBy(query.getIsAsc() ? "ASC" : "DESC");
    }

    private void calculateOffset(PageReq query) {
        query.setOffset((query.getPageNo() - 1) * query.getPageSize());
    }

    private String getLastUpdateTimeFromRedis(String key) {
        try {
            String value = redisTemplate.opsForValue().get(key);
            return value != null ? value : null;
        } catch (Exception e) {
            // 记录日志
            log.info("从Redis中获取key:{}失败，失败原因:{}", key, e.getMessage());
            return null;
        }
    }

    private void saveLastUpdateTimeToRedis(String key, String lastUpdateTime) {
        try {
            redisTemplate.opsForValue().set(key, lastUpdateTime, REDIS_EXPIRE_TIME, TimeUnit.SECONDS);
        } catch (Exception e) {
            // 记录日志
            log.info("向Redis中保存key:{}，值:{}失败，失败原因:{}", key, lastUpdateTime, e.getMessage());
        }
    }
}
