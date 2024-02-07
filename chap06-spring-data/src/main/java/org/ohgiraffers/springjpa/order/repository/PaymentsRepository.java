package org.ohgiraffers.springjpa.order.repository;

import org.ohgiraffers.springjpa.order.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {
}
