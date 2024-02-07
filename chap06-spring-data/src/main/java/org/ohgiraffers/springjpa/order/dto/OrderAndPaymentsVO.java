package org.ohgiraffers.springjpa.order.dto;

import org.ohgiraffers.springjpa.order.entity.Payments;

import java.util.Date;
import java.util.List;

public class OrderAndPaymentsVO {

    private int menuCode;

    private Date orderDate;

    private List<Payments> payments;

    public OrderAndPaymentsVO() {
    }

    public OrderAndPaymentsVO(int menuCode, Date orderDate, List<Payments> payments) {
        this.menuCode = menuCode;
        this.orderDate = orderDate;
        this.payments = payments;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "OrderAndPaymentsVO{" +
                "menuCode=" + menuCode +
                ", orderDate=" + orderDate +
                ", payments=" + payments +
                '}';
    }
}
