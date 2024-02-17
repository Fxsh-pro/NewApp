package com.backend.zlpfinpd.controller;

import com.backend.zlpfinpd.model.dto.TransactionDto;
import com.backend.zlpfinpd.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping()
    public ResponseEntity<List<TransactionDto>> getTransactions(@RequestParam LocalDate date_from, @RequestParam LocalDate date_to) {
        var transactions = transactionService.getTransactions(date_from, date_to);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        TransactionDto createdTransaction = transactionService.createTransaction(transactionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }
}
