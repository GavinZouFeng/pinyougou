package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.order.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 邹峰
 * @title: indexController
 * @projectName ProjectShiZhan
 * @description: TODO
 * @date 2019/6/4 16:13
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @Reference
    private OrderService orderService;

    @RequestMapping("/countOrders")
    public List<Map> countOrders(){
        return orderService.countOrder();
    }
}
