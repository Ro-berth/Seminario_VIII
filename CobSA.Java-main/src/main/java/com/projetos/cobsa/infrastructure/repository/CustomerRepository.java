package com.projetos.cobsa.infrastructure.repository;

import com.projetos.cobsa.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Aqui você pode adicionar métodos de consulta customizados, se necessário
}
