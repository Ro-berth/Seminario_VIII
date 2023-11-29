package com.projetos.cobsa.application.web.controller;

import com.projetos.cobsa.application.dto.BillingDTO;
import com.projetos.cobsa.domain.entity.Billing;
import com.projetos.cobsa.domain.service.BillingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/billings")
public class BillingController {

    private final BillingService billingService;
    private final ModelMapper modelMapper;

    @Autowired
    public BillingController(BillingService billingService, ModelMapper modelMapper) {
        this.billingService = billingService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BillingDTO> getAllBillings() {
        return billingService.findAll().stream()
                .map(billing -> modelMapper.map(billing, BillingDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingDTO> getBillingById(@PathVariable Long id) {
        return billingService.findById(id)
                .map(billing -> ResponseEntity.ok(modelMapper.map(billing, BillingDTO.class)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BillingDTO createBilling(@RequestBody BillingDTO billingDTO) {
        Billing billing = modelMapper.map(billingDTO, Billing.class);
        Billing createdBilling = billingService.save(billing);
        return modelMapper.map(createdBilling, BillingDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillingDTO> updateBilling(@PathVariable Long id, @RequestBody BillingDTO billingDTO) {
        return billingService.findById(id)
                .map(billing -> {
                    modelMapper.map(billingDTO, billing);
                    Billing updatedBilling = billingService.save(billing);
                    return ResponseEntity.ok(modelMapper.map(updatedBilling, BillingDTO.class));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable Long id) {
        billingService.delete(id);
        return ResponseEntity.ok().build();
    }
}

