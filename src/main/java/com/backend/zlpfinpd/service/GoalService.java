package com.backend.zlpfinpd.service;

import com.backend.zlpfinpd.model.dto.GoalDto;
import com.backend.zlpfinpd.model.entity.User;
import com.backend.zlpfinpd.repository.GoalRepository;
import com.backend.zlpfinpd.utils.mapper.GoalMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
    private final GoalMapper goalMapper;

    public List<GoalDto> getGoals() {
        Long userId = 12L; // i need to get that info from gwt
        var goals = goalRepository.getGoalsByUserId(userId);
        return goals.stream().map(goalMapper::toDto).toList();
    }

    public GoalDto createGoal(GoalDto goalDto) {
        var g = goalMapper.toEntity(goalDto);
        System.out.println(g);
        g.setUser(User.builder().id(goalDto.getUserId()).build());

        var goal = goalRepository.save(g);
        return goalMapper.toDto(goal);
    }
}