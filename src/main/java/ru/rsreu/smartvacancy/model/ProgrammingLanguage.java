package ru.rsreu.smartvacancy.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum ProgrammingLanguage {
    C("C"),
    CPP("C++"),
    JAVA("Java"),
    JAVASCRIPT("Javascript"),
    KOTLIN("Kotlin"),
    PYTHON("Python"),
    ONE_C("1C"),
    RUBY("Ruby"),
    SWIFT("Swift"),
    PHP("PHP");

    private final String languageName;

    private static final Map<String, ProgrammingLanguage> LANGUAGES_BY_NAMES = Arrays.stream(values())
            .collect(Collectors.toMap(l -> l.getLanguageName().toLowerCase(), Function.identity()));

    public ProgrammingLanguage byLanguageName(String name) {
        return LANGUAGES_BY_NAMES.get(name.toLowerCase());
    }
}
