package ru.rsreu.smartvacancy.domain.processing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.rsreu.smartvacancy.domain.model.Employee;
import ru.rsreu.smartvacancy.domain.model.Vacancy;
import ru.rsreu.smartvacancy.domain.service.employee.EmployeeLoader;
import ru.rsreu.smartvacancy.domain.service.vacancy.VacancyLoader;
import ru.rsreu.smartvacancy.processing.api.ProcessingSystem;
import ru.rsreu.smartvacancy.processing.model.ProcessingModel;
import ru.rsreu.smartvacancy.processing.service.ProcessingSystemImpl;

import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class VacanciesFinder {
    private final VacancyLoader vacancyLoader;
    private final EmployeeLoader employeeLoader;
    private final Function<Vacancy, ProcessingModel<Vacancy>> vacancyToProcessingModelMapper;
    private final Function<Employee, Vacancy> employeeToVacancyMapper;

    public List<Vacancy> find(int limit) {
        Vacancy perfectVacancy = employeeToVacancyMapper.apply(employeeLoader.loadEmployee());
        List<Vacancy> vacancies = vacancyLoader.loadVacancies();
        vacancies.add(perfectVacancy);

        List<ProcessingModel<Vacancy>> models = vacancies.stream()
                .map(vacancyToProcessingModelMapper)
                .toList();

        ProcessingSystem<Vacancy> processingSystem = new ProcessingSystemImpl<>();
        processingSystem.inputModels(models);
        processingSystem.normalize();
        return processingSystem.findSimilar(perfectVacancy, limit);
    }
}
