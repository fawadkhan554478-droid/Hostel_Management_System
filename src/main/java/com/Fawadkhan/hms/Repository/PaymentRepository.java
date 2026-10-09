package com.Fawadkhan.hms.Repository;

import com.Fawadkhan.hms.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}