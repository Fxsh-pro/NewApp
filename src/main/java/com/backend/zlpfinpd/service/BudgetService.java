package com.backend.zlpfinpd.service;

import com.backend.zlpfinpd.model.dto.BudgetDto;
import com.backend.zlpfinpd.model.entity.Goal;
import com.backend.zlpfinpd.model.entity.User;
import com.backend.zlpfinpd.repository.BudgetRepository;
import com.backend.zlpfinpd.utils.mapper.BudgetMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;

    public BudgetDto getBudgetById(Long budgetId) {
        var budget = budgetRepository.getBudgetById(budgetId).orElseThrow(
                () -> new EntityNotFoundException("No budget with id " + budgetId)
        );
        return budgetMapper.toDto(budget);
    }

    public BudgetDto createBudget(BudgetDto budgetDto) {
        var budget = budgetMapper.toEntity(budgetDto);
        System.out.println(budget);
        budget.setUser(User.builder().id(budgetDto.getUserId()).build());
        budget.setGoal(Goal.builder().id(budgetDto.getGoalId()).build());
        var createdModel = budgetRepository.save(budget);
        return budgetMapper.toDto(createdModel);
    }
}
