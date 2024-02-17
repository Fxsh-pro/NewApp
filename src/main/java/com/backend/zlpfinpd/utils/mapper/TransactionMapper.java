package com.backend.zlpfinpd.utils.mapper;

import com.backend.zlpfinpd.model.dto.TransactionDto;
import com.backend.zlpfinpd.model.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    TransactionDto toDto(Transaction transaction);

    Transaction toEntity(TransactionDto transactionDto);
}
