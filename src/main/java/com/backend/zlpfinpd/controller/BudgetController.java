package com.backend.zlpfinpd.controller;

import com.backend.zlpfinpd.model.dto.BudgetDto;
import com.backend.zlpfinpd.model.dto.UserDto;
import com.backend.zlpfinpd.service.BudgetService;
import com.backend.zlpfinpd.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/budget")
public class BudgetController {
    private final BudgetService budgetService;

    @GetMapping("/{budgetId}")
    public ResponseEntity<BudgetDto> getBudget(@PathVariable Long budgetId) {
        BudgetDto budgetDTO = budgetService.getBudgetById(budgetId);
        return ResponseEntity.ok(budgetDTO);
    }

    @PostMapping
    public ResponseEntity<BudgetDto> createBudget(@Valid @RequestBody BudgetDto budgetDto, Principal principal) {
        System.out.println(principal.getName());
        BudgetDto createdBudget = budgetService.createBudget(budgetDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBudget);
    }

//    @PutMapping("/{budgetId}")
//    public ResponseEntity<BudgetDto> updateBudget(@PathVariable Long budgetId, @Valid @RequestBody BudgetDto budgetDTO) {
//        BudgetDto updatedBudget = budgetService.updateBudget(budgetId, budgetDTO);
//        return ResponseEntity.ok(updatedBudget);
//    }
//
//    @DeleteMapping("/{budgetId}")
//    public ResponseEntity<?> deleteBudget(@PathVariable Long budgetId) {
//        budgetService.deleteBudget(budgetId);
//        return ResponseEntity.ok().build();
//    }
}
