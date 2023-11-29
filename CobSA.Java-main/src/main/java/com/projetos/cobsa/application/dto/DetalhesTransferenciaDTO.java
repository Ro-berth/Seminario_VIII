package com.projetos.cobsa.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalhesTransferenciaDTO {

    private Long id;
    private String bancoDestino;
    private String agencia;
    private String conta;
    private String nomeTitular;
}
