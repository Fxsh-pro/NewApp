package com.backend.zlpfinpd.utils.mapper;

import com.backend.zlpfinpd.model.dto.BudgetDto;
import com.backend.zlpfinpd.model.entity.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BudgetMapper {
    BudgetDto toDto(Budget budget);

    Budget toEntity(BudgetDto budgetDto);
}