package ru.rsreu.smartvacancy.domain.service.vacancy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import ru.rsreu.smartvacancy.domain.model.Vacancy;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VacancyLoaderImpl implements VacancyLoader {
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Override
    @SneakyThrows
    public List<Vacancy> loadVacancies() {
        Resource resource = resourceLoader.getResource("classpath:vacancies.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }
}
