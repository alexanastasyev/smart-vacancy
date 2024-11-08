package ru.rsreu.smartvacancy.domain.service.vacancy;

import ru.rsreu.smartvacancy.domain.model.Vacancy;

import java.util.List;

public interface VacancyLoader {
    List<Vacancy> loadVacancies();
}
