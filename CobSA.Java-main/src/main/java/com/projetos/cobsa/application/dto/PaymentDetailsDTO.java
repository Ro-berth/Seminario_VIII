package com.projetos.cobsa.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDetailsDTO {
    private Long paymentId;
    private CustomerDTO cliente;
    private BillingDTO cobranca;
    private DetalhesTransferenciaDTO transferencia;
}
