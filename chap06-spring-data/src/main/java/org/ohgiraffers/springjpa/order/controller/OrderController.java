package org.ohgiraffers.springjpa.order.controller;

import org.ohgiraffers.springjpa.menu.entity.Menu;
import org.ohgiraffers.springjpa.order.dto.OrderAndPaymentsVO;
import org.ohgiraffers.springjpa.order.entity.MenuOrder;
import org.ohgiraffers.springjpa.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity order(@RequestBody HashMap<String, Integer> menuCode) {

        MenuOrder result = orderService.order(menuCode.get("menuCode"));

        if (Objects.isNull(result)) {
            return ResponseEntity.status(400).body("주문 실패");
        }

        OrderAndPaymentsVO orderAndPaymentsVO = new OrderAndPaymentsVO();
        orderAndPaymentsVO.setPayments(result.getPayments());
        orderAndPaymentsVO.setMenuCode(result.getMenu());
        orderAndPaymentsVO.setOrderDate(result.getOrderDate());

        return ResponseEntity.ok(orderAndPaymentsVO);

    }
}
