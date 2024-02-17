package com.backend.zlpfinpd.utils.mapper;

import com.backend.zlpfinpd.model.dto.GoalDto;
import com.backend.zlpfinpd.model.entity.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GoalMapper {
    GoalDto toDto(Goal goal);

    Goal toEntity(GoalDto goalDto);
}

