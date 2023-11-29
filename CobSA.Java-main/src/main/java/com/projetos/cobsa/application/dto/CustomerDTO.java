package com.projetos.cobsa.application.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String document;
    private String email;
    private String phone;
}
