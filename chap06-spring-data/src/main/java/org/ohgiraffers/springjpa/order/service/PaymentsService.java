package org.ohgiraffers.springjpa.order.service;

import org.ohgiraffers.springjpa.order.entity.Payments;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentsService {

    public Payments orderPayments(int value/*예시*/) {
        Payments payments = new Payments();

        payments.setPaymentsDate(new Date());

        return payments;
    }
}
