package com.projetos.cobsa.application.web.controller;

import com.projetos.cobsa.domain.service.PaymentService;
import com.projetos.cobsa.domain.entity.Payment;
import com.projetos.cobsa.application.dto.PaymentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    private Payment convertToEntity(PaymentDTO paymentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(paymentDTO, Payment.class);
    }

    // Método para converter entidade para DTO
    private PaymentDTO convertToDto(Payment payment) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(payment, PaymentDTO.class);
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> processPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = convertToEntity(paymentDTO);
        Payment processedPayment = paymentService.processPayment(payment);
        PaymentDTO processedPaymentDTO = convertToDto(processedPayment);
        return new ResponseEntity<>(processedPaymentDTO, HttpStatus.CREATED);
    }

    // Outros endpoints conforme necessário...
}