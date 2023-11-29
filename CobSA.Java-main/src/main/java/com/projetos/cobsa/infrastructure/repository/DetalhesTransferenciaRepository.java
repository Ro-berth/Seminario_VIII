package com.projetos.cobsa.infrastructure.repository;

import com.projetos.cobsa.domain.entity.DetalhesTransferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalhesTransferenciaRepository extends JpaRepository<DetalhesTransferencia, Long> {
    // Aqui você pode adicionar consultas personalizadas, se necessário
}
