package org.ohgiraffers.springjpa.order.service;

import org.ohgiraffers.springjpa.order.dto.OrderAndPaymentsVO;
import org.ohgiraffers.springjpa.order.entity.MenuOrder;
import org.ohgiraffers.springjpa.order.entity.Payments;
import org.ohgiraffers.springjpa.order.infra.MenuFind;
import org.ohgiraffers.springjpa.order.repository.OrderRepository;
import org.ohgiraffers.springjpa.order.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private MenuFind menuFind;

    @Autowired
    private PaymentsService paymentsService;

    public MenuOrder order(Integer menuCode) {
        Integer findMenuCode = menuFind.findMenuCode(menuCode);

        if (Objects.isNull(findMenuCode)){
            return null;
        }

        MenuOrder menuOrder = new MenuOrder();
        menuOrder.setMenu(findMenuCode);
        menuOrder.setOrderDate(new Date());

        // 결제 대행사 수행하는 로직이 있다고 가정
        Payments resultPayments = paymentsService.orderPayments(0);

        // 주문에 결제 정보 등록
        resultPayments.setMenuOrder(menuOrder);
        menuOrder.getPayments().add(resultPayments);

        MenuOrder result = orderRepository.save(menuOrder);

        return result;

    }

}
