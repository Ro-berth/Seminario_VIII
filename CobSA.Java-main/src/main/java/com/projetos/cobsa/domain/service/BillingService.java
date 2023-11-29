package com.projetos.cobsa.domain.service;

import com.projetos.cobsa.domain.entity.Billing;
import com.projetos.cobsa.infrastructure.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Billing> findById(Long id) {
        return billingRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Billing> findAll() {
        return billingRepository.findAll();
    }

    @Transactional
    public Billing save(Billing billing) {
        return billingRepository.save(billing);
    }

    @Transactional
    public void delete(Long id) {
        billingRepository.deleteById(id);
    }

    // Adicione outros métodos conforme o necessário para a lógica de cobrança
}
