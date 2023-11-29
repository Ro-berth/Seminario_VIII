package com.projetos.cobsa.domain.service;

import com.projetos.cobsa.domain.entity.Payment;
import com.projetos.cobsa.infrastructure.repository.PaymentRepository;
import com.projetos.cobsa.infrastructure.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.Optional;

@Service
public class PaymentService {


    private final PaymentRepository paymentRepository;
    private final DetalhesTransferenciaService detalhesTransferenciaService;
    private final BillingRepository billingRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository,
                          DetalhesTransferenciaService detalhesTransferenciaService,
                          BillingRepository billingRepository) {
        this.paymentRepository = paymentRepository;
        this.detalhesTransferenciaService = detalhesTransferenciaService;
        this.billingRepository = billingRepository;
    }



    @Transactional
    public Payment processPayment(Payment payment) {
        if (payment.getBilling() == null) {
            throw new IllegalStateException("Informações de cobrança ausentes no pagamento.");
        }

        if (payment.getBilling().getStatus().equals("PAGO")) {
            throw new IllegalStateException("A cobrança já foi paga.");
        }

        if (payment.getMetodoPagamento().equals("TRANSFERENCIA") &&
                !detalhesTransferenciaService.isPaymentValid(payment.getDetalhesTransferencia())) {
            throw new IllegalArgumentException("Os detalhes da transferência são inválidos.");
        }

        payment.getBilling().setStatus("PAGO");

        if (payment.getMetodoPagamento().equals("TRANSFERENCIA")) {
            detalhesTransferenciaService.saveDetails(payment.getDetalhesTransferencia());
        }

        if (payment.getBilling().getId() == null) {
            billingRepository.save(payment.getBilling());
        }

        return paymentRepository.save(payment);
    }


    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }
}
