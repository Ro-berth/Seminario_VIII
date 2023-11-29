package com.projetos.cobsa.domain.service;

import com.projetos.cobsa.domain.entity.*;
import com.projetos.cobsa.infrastructure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private DetalhesTransferenciaRepository detalhesTransferenciaRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public String generateCustomerCsvReport() {
        List<Customer> customers = customerRepository.findAll();
        String header = "ID,Name,Document,Email,Phone"; // Cabeçalho para Customer
        return header + "\n" + customers.stream()
                .map(this::convertToCsvLine)
                .collect(Collectors.joining("\n"));
    }

    private String convertToCsvLine(Customer customer) {
        // Converte Customer em uma linha de CSV
        return String.join(",",
                customer.getId().toString(),
                customer.getName(),
                customer.getDocument(),
                customer.getEmail(),
                customer.getPhone()
                // ... outros campos se necessário
        );
    }

    public String generateBillingCsvReport() {
        List<Billing> billings = billingRepository.findAll();
        String header = "ID,Due Date,Amount,Status"; // Cabeçalho para Billing
        return header + "\n" + billings.stream()
                .map(this::convertToCsvLine)
                .collect(Collectors.joining("\n"));
    }

    private String convertToCsvLine(Billing billing) {
        // Converte Billing em uma linha de CSV
        return String.join(",",
                billing.getId().toString(),
                billing.getDueDate().toString(),
                billing.getAmount().toString(),
                billing.getStatus()
                // ... outros campos se necessário
        );
    }

    public String generateDetalhesTransferenciaCsvReport() {
        List<DetalhesTransferencia> detalhes = detalhesTransferenciaRepository.findAll();
        String header = "ID,Banco Destino,Agência,Conta,Nome Titular"; // Cabeçalho para DetalhesTransferencia
        return header + "\n" + detalhes.stream()
                .map(this::convertToCsvLine)
                .collect(Collectors.joining("\n"));
    }

    private String convertToCsvLine(DetalhesTransferencia detalhe) {
        // Converte DetalhesTransferencia em uma linha de CSV
        return String.join(",",
                detalhe.getId().toString(),
                detalhe.getBancoDestino(),
                detalhe.getAgencia(),
                detalhe.getConta(),
                detalhe.getNomeTitular()
                // ... outros campos se necessário
        );
    }

    public String generatePaymentCsvReport() {
        List<Payment> payments = paymentRepository.findAll();
        String header = "ID,Valor,Data Pagamento,Método Pagamento,Billing ID,Detalhes Transferência ID"; // Cabeçalho para Payment
        return header + "\n" + payments.stream()
                .map(this::convertToCsvLine)
                .collect(Collectors.joining("\n"));
    }

    private String convertToCsvLine(Payment payment) {
        // Converte Payment em uma linha de CSV
        return String.join(",",
                payment.getId().toString(),
                payment.getValor().toString(),
                payment.getDataPagamento().toString(),
                payment.getMetodoPagamento(),
                payment.getBilling().getId().toString(),
                payment.getDetalhesTransferencia() != null ? payment.getDetalhesTransferencia().getId().toString() : "N/A"
                // ... outros campos se necessário
        );
    }

}
