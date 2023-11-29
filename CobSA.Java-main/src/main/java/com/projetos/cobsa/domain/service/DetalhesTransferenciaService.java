package com.projetos.cobsa.domain.service;

import com.projetos.cobsa.domain.entity.DetalhesTransferencia;
import com.projetos.cobsa.infrastructure.repository.DetalhesTransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.Optional;

@Service
public class DetalhesTransferenciaService {

    private final DetalhesTransferenciaRepository detalhesTransferenciaRepository;

    @Autowired
    public DetalhesTransferenciaService(DetalhesTransferenciaRepository detalhesTransferenciaRepository) {
        this.detalhesTransferenciaRepository = detalhesTransferenciaRepository;
    }

    @Transactional
    public DetalhesTransferencia saveDetails(DetalhesTransferencia transferenciaDetails) {
        // Validar os campos necessários da transferência.
        validateTransferDetails(transferenciaDetails);

        // Pode-se inserir lógica adicional aqui, como checar a disponibilidade do serviço do banco,
        // limites de transferência, ou outras regras de negócio relacionadas.

        // Após a validação, salvar os detalhes da transferência no banco de dados.
        return detalhesTransferenciaRepository.save(transferenciaDetails);
    }

    private void validateTransferDetails(DetalhesTransferencia transferenciaDetails) {
        if (transferenciaDetails.getBancoDestino() == null || transferenciaDetails.getBancoDestino().trim().isEmpty()) {
            throw new IllegalArgumentException("O banco de destino é obrigatório.");
        }
        if (transferenciaDetails.getAgencia() == null || transferenciaDetails.getAgencia().trim().isEmpty()) {
            throw new IllegalArgumentException("A agência é obrigatória.");
        }
        if (transferenciaDetails.getConta() == null || transferenciaDetails.getConta().trim().isEmpty()) {
            throw new IllegalArgumentException("A conta é obrigatória.");
        }
        if (transferenciaDetails.getNomeTitular() == null || transferenciaDetails.getNomeTitular().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do titular é obrigatório.");
        }
    }

    public boolean isPaymentValid(DetalhesTransferencia detalhesTransferencia) {
        if (detalhesTransferencia.getBancoDestino() == null || detalhesTransferencia.getBancoDestino().trim().isEmpty()) {
            return false;
        }
        if (detalhesTransferencia.getAgencia() == null || detalhesTransferencia.getAgencia().trim().isEmpty()) {
            return false;
        }
        if (detalhesTransferencia.getConta() == null || detalhesTransferencia.getConta().trim().isEmpty()) {
            return false;
        }
        return detalhesTransferencia.getNomeTitular() != null && !detalhesTransferencia.getNomeTitular().trim().isEmpty();
    }


    public Optional<DetalhesTransferencia> findById(Long id) {
        return detalhesTransferenciaRepository.findById(id);
    }
}
