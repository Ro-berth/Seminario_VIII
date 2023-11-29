package com.projetos.cobsa.application.web.controller;

import com.projetos.cobsa.domain.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/customers")
    public ResponseEntity<String> getCustomersReport() {
        String csv = reportService.generateCustomerCsvReport();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "text/csv")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"customers_report.csv\"")
                .body(csv);
    }

    @GetMapping("/billings")
    public ResponseEntity<String> getBillingsReport() {
        String csv = reportService.generateBillingCsvReport();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "text/csv")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"billings_report.csv\"")
                .body(csv);
    }

    @GetMapping("/transfer-details")
    public ResponseEntity<String> getTransferDetailsReport() {
        String csv = reportService.generateDetalhesTransferenciaCsvReport();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "text/csv")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"transfer_details_report.csv\"")
                .body(csv);
    }

    @GetMapping("/payments")
    public ResponseEntity<String> getPaymentsReport() {
        String csv = reportService.generatePaymentCsvReport();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "text/csv")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"payments_report.csv\"")
                .body(csv);
    }

    // ... outros métodos se necessário
}
