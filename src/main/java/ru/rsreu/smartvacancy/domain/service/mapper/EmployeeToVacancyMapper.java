package ru.rsreu.smartvacancy.domain.service.mapper;

import org.springframework.stereotype.Component;
import ru.rsreu.smartvacancy.domain.model.Employee;
import ru.rsreu.smartvacancy.domain.model.Vacancy;

import java.util.ArrayList;
import java.util.function.Function;

@Component
public class EmployeeToVacancyMapper implements Function<Employee, Vacancy> {
    @Override
    public Vacancy apply(Employee employee) {
        return Vacancy.builder()
                .title("Fake")
                .languages(new ArrayList<>(employee.getLanguages()))
                .technologies(new ArrayList<>(employee.getTechnologies()))
                .experienceMonths(employee.getExperienceMonths())
                .employmentType(employee.getEmploymentType())
                .remoteWorkType(employee.getRemoteWorkType())
                .salaryFrom(employee.getSalaryFrom())
                .salaryTo(employee.getSalaryTo())
                .build();
    }
}
