package ru.rsreu.smartvacancy.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Technology {
    SPRING("Spring"),
    SPRING_BOOT("Spring Boot"),
    REACT("React"),
    ANGULAR("Angular"),
    DJANGO("Django"),
    LARAVEL("Laravel"),
    DOCKER("Docker"),
    KUBERNETES("Kubernetes"),
    AWS("AWS"),
    AZURE("Azure"),
    GIT("Git"),
    GITHUB("GitHub"),
    GITLAB("GitLab"),
    SQL("SQL"),
    POSTGRESQL("PostgreSQL"),
    ORACLEDB("OracleDB"),
    MONGODB("MongoDB"),
    JENKINS("Jenkins"),
    GITLAB_ACTIONS("Gitlab Actions"),
    SELENIUM("Selenium"),
    JUNIT("Junit");

    private final String technologyName;

    private static final Map<String, Technology> TECHNOLOGIES_BY_NAMES = Arrays.stream(values())
            .collect(Collectors.toMap(t -> t.getTechnologyName().toLowerCase(), Function.identity()));

    public Technology byTechnologyName(String name) {
        return TECHNOLOGIES_BY_NAMES.get(name.toLowerCase());
    }
}
