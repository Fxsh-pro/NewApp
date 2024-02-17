package com.backend.zlpfinpd.service;

import com.backend.zlpfinpd.model.dto.TransactionDto;
import com.backend.zlpfinpd.model.entity.Budget;
import com.backend.zlpfinpd.model.entity.User;
import com.backend.zlpfinpd.repository.TransactionRepository;
import com.backend.zlpfinpd.utils.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public List<TransactionDto> getTransactions(LocalDate dateFrom, LocalDate dateTo) {
        LocalDateTime startOfDay = LocalDateTime.of(dateFrom, LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(dateTo, LocalTime.MAX);

        var transactions = transactionRepository.findTransactionsBetweenDates(startOfDay, endOfDay);
        return transactions.stream().map(transactionMapper::toDto).toList();
    }

    public TransactionDto createTransaction(TransactionDto transactionDto) {
        var transaction = transactionMapper.toEntity(transactionDto);
        transaction.setUser(User.builder().id(transactionDto.getUserId()).build());
        transaction.setBudgetFrom(Budget.builder().id(transactionDto.getBudgetFromId()).build());
        transaction.setBudgetTo(Budget.builder().id(transactionDto.getBudgetToId()).build());
        var createdModel = transactionRepository.save(transaction);
        return transactionMapper.toDto(createdModel);
    }
}