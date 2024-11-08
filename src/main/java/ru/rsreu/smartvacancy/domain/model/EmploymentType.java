package ru.rsreu.smartvacancy.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum EmploymentType {
    FULL_TIME("Full-time"),
    PART_TIME("Part-time"),
    CONTRACT("By contract");

    private final String typeName;

    private static final Map<String, EmploymentType> EMPLOYMENT_TYPES_BY_NAME = Arrays.stream(values())
            .collect(Collectors.toMap(e -> e.getTypeName().toLowerCase(), Function.identity()));

    public EmploymentType byTypeName(String name) {
        return EMPLOYMENT_TYPES_BY_NAME.get(name.toLowerCase());
    }
}
