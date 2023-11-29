package com.projetos.cobsa.domain.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String document; // CPF/CNPJ
    private String email;
    private String phone;

    @OneToMany(mappedBy = "customer")
    private Set<Billing> billings;
}
