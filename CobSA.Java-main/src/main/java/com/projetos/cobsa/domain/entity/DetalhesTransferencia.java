package com.projetos.cobsa.domain.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class DetalhesTransferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bancoDestino;
    private String agencia;
    private String conta;
    private String nomeTitular;
}
