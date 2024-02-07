package org.ohgiraffers.springjpa.order.repository;

import org.ohgiraffers.springjpa.order.entity.MenuOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<MenuOrder, Integer> {

}
