package com.projetos.cobsa.application.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PaymentDTO {

    private Long id;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private String metodoPagamento;
    private DetalhesTransferenciaDTO detalhesTransferencia;
    private BillingDTO billing;
}
