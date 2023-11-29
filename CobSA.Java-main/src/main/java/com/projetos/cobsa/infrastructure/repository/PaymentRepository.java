package com.projetos.cobsa.infrastructure.repository;

import com.projetos.cobsa.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Aqui você pode adicionar consultas personalizadas, se necessário
}
