package com.projetos.cobsa.domain.entity;

import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private LocalDate dataPagamento;
    private String metodoPagamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalhes_transferencia_id", referencedColumnName = "id")
    private DetalhesTransferencia detalhesTransferencia;

    @ManyToOne
    @JoinColumn(name = "billing_id")
    private Billing billing;
}
