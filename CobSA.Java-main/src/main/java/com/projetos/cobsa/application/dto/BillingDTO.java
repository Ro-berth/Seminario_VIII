package com.projetos.cobsa.application.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BillingDTO {
    private Long id;
    private LocalDate dueDate;
    private BigDecimal amount;
    private String status;
    private Long customerId;
}