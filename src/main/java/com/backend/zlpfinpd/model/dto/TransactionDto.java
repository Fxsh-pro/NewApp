package com.backend.zlpfinpd.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Long id;
    @NotNull
    private Long userId;
    private String title;
    private LocalDateTime date;
    private BigDecimal amount;
    @NotNull
    private Long budgetFromId;
    @NotNull
    private Long budgetToId;
}
