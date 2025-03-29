package com.cwb.controller;

import com.cwb.common.constants.Constants;
import com.cwb.common.response.Response;
import com.cwb.controller.dto.ItemPageDTO;
import com.cwb.domain.po.Item;
import com.cwb.domain.res.PageReq;
import com.cwb.service.IItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName：ItemController
 * @Author: caowenbo
 * @Date: 2025/3/21 22:14
 * @Description: 商品操作
 */

@RestController
@RequestMapping("/items/")
@CrossOrigin("*")
public class ItemController {
    @Resource
    IItemService itemService;

    @RequestMapping(value = "page", method = RequestMethod.POST)
    public Response<ItemPageDTO> queryItemByPage(@RequestBody PageReq query) {
        try {
            List<Item> itemList = itemService.getItemList(query);
            ItemPageDTO itemPageDTO = new ItemPageDTO();
            itemPageDTO.setItems(itemList);
            return Response.<ItemPageDTO>builder()
                    .code(Constants.ResponseCode.SUCCESS.getCode())
                    .info(Constants.ResponseCode.SUCCESS.getInfo())
                    .data(itemPageDTO)
                    .build();
        } catch (Exception e) {
            return Response.<ItemPageDTO>builder()
                    .code(Constants.ResponseCode.UN_ERROR.getCode())
                    .info(Constants.ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }

    @RequestMapping(value = "keyword", method = RequestMethod.GET)
    public Response<ItemPageDTO> queryItemByKeyword(@RequestParam String name) {
        try {
            List<Item> itemList = itemService.getItemListByKeyword(name);
            ItemPageDTO itemPageDTO = new ItemPageDTO();
            itemPageDTO.setItems(itemList);
            return Response.<ItemPageDTO>builder()
                    .code(Constants.ResponseCode.SUCCESS.getCode())
                    .info(Constants.ResponseCode.SUCCESS.getInfo())
                    .data(itemPageDTO)
                    .build();
        } catch (Exception e) {
            return Response.<ItemPageDTO>builder()
                    .code(Constants.ResponseCode.UN_ERROR.getCode())
                    .info(Constants.ResponseCode.UN_ERROR.getInfo())
                    .build();
        }

    }

    @RequestMapping(value = "id", method = RequestMethod.GET)
    public Response<Item> queryItemById(@RequestParam String id) {
        try {
            Item item = itemService.getItemListById(id);
            return Response.<Item>builder()
                    .code(Constants.ResponseCode.SUCCESS.getCode())
                    .info(Constants.ResponseCode.SUCCESS.getInfo())
                    .data(item)
                    .build();
        } catch (Exception e) {
            return Response.<Item>builder()
                    .code(Constants.ResponseCode.UN_ERROR.getCode())
                    .info(Constants.ResponseCode.UN_ERROR.getInfo())
                    .build();
        }

    }
}
