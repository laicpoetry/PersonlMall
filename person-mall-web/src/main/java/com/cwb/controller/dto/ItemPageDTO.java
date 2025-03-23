package com.cwb.controller.dto;

import com.cwb.domain.po.Item;
import lombok.Data;

import java.util.List;

/**
 * @ClassName：ItemDTO
 * @Author: caowenbo
 * @Date: 2025/3/22 21:16
 * @Description:
 */
@Data
public class ItemPageDTO {

    private List<Item> items;

}
