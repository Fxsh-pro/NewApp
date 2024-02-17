package com.backend.zlpfinpd.controller;

import com.backend.zlpfinpd.model.dto.GoalDto;
import com.backend.zlpfinpd.service.GoalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/goal")
public class GoalController {
    private final GoalService goalService;

    @GetMapping()
    public ResponseEntity<List<GoalDto>> getGoals() {
        List<GoalDto> goalDto = goalService.getGoals();
        return ResponseEntity.ok(goalDto);
    }

    @PostMapping
    public ResponseEntity<GoalDto> createGoal(@Valid @RequestBody GoalDto goalDto, Principal principal) {
        System.out.println(principal.getName());
        System.out.println(goalDto);
        GoalDto createdGoal = goalService.createGoal(goalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoal);
    }
}
