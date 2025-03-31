package com.cwb.controller;

import com.cwb.common.constants.Constants;
import com.cwb.common.response.Response;
import com.cwb.controller.dto.ItemPageDTO;
import com.cwb.domain.po.Cart;
import com.cwb.domain.po.Item;
import com.cwb.domain.vo.CartFormVO;
import com.cwb.service.ICartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName：CartController
 * @Author: caowenbo
 * @Date: 2025/3/31 20:58
 * @Description:
 */
@RestController
@RequestMapping("/cart/")
@CrossOrigin("*")
@Slf4j
public class CartController {
    @Resource
    private ICartService cartService;

    @RequestMapping(value = "additemcart",method = RequestMethod.POST)
    public void addItem2Cart(@Valid @RequestBody CartFormVO cartFormVO){
        log.info("添加购物车请求cartFormVO: {}", cartFormVO);
        try{
            log.info("添加购物车成功");
            cartService.addItem2Cart(cartFormVO);
        }catch (Exception e){
            log.info("添加购物车失败", e);
        }
    }

    @RequestMapping(value = "querymycarts",method = RequestMethod.GET)
    public Response<List<Cart>> queryMyCarts(){
        try {
            log.info("用户购物车查询成功");
            List<Cart> carts = cartService.queryMyCarts();
            return Response.<List<Cart>>builder()
                    .code(Constants.ResponseCode.SUCCESS.getCode())
                    .info(Constants.ResponseCode.SUCCESS.getInfo())
                    .data(carts)
                    .build();
        } catch (Exception e) {
            log.info("用户购物车查询失败");
            return Response.<List<Cart>>builder()
                    .code(Constants.ResponseCode.UN_ERROR.getCode())
                    .info(Constants.ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }

}
