package com.miguelmendezz.the_pass.repository;

import com.miguelmendezz.the_pass.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
