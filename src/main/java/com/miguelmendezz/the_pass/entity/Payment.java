package com.miguelmendezz.the_pass.entity;

import com.miguelmendezz.the_pass.entity.enums.PaymentMethod;
import com.miguelmendezz.the_pass.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    @Positive
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;
    @NotNull
    @Column(nullable = false, length = 3)
    private String currencyCode;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod method;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;
    @Column(nullable = false)
    private Instant createdAt;

    public Payment() {
    }

    public Payment(BigDecimal amount, String currencyCode, PaymentMethod method) {
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.method = method;
        this.status = PaymentStatus.PENDING;
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
