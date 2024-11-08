package ru.rsreu.smartvacancy.domain.service.mapper;

import org.springframework.stereotype.Component;
import ru.rsreu.smartvacancy.domain.model.*;
import ru.rsreu.smartvacancy.processing.model.ProcessingModel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class VacancyToProcessingModelMapper implements Function<Vacancy, ProcessingModel<Vacancy>> {
    @Override
    public ProcessingModel<Vacancy> apply(Vacancy vacancy) {
        Map<String, Double> processingValues = new HashMap<>();

        Arrays.asList(ProgrammingLanguage.values()).forEach(lang ->
                processingValues.put("lang_%s".formatted(lang.name().toLowerCase()), vacancy.getLanguages().contains(lang) ? 1d : 0d));

        Arrays.asList(Technology.values()).forEach(tech ->
                processingValues.put("tech_%s".formatted(tech.name().toLowerCase()), vacancy.getTechnologies().contains(tech) ? 1d : 0d));

        Arrays.asList(EmploymentType.values()).forEach(type ->
                processingValues.put("employment_type_%s".formatted(type.name().toLowerCase()), vacancy.getEmploymentType().equals(type) ? 1d : 0d));

        Arrays.asList(RemoteWorkType.values()).forEach(type ->
                processingValues.put("work_type_%s".formatted(type.name().toLowerCase()), vacancy.getRemoteWorkType().equals(type) ? 1d : 0d));

        processingValues.put("experience", vacancy.getExperienceMonths().doubleValue());
        processingValues.put("salary_from", vacancy.getSalaryFrom().doubleValue());
        processingValues.put("salary_to", vacancy.getSalaryTo().doubleValue());

        return new ProcessingModel<>(vacancy, processingValues);
    }
}
