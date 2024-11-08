package ru.rsreu.smartvacancy.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum RemoteWorkType {
    ON_SITE("On-site"),
    REMOTE("Remote"),
    HYBRID("Hybrid");

    private final String typeName;

    private static final Map<String, RemoteWorkType> TYPES_BY_NAMES = Arrays.stream(values())
            .collect(Collectors.toMap(r -> r.getTypeName().toLowerCase(), Function.identity()));

    public RemoteWorkType byTypeName(String name) {
        return TYPES_BY_NAMES.get(name.toLowerCase());
    }
}
