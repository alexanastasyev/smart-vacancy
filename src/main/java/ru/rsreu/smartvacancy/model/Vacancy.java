package ru.rsreu.smartvacancy.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class Vacancy {
    private String title;
    private Set<ProgrammingLanguage> languages;
    private Set<Technology> technologies;
    private Integer experienceMonths;
    private EmploymentType employmentType;
    private RemoteWorkType remoteWorkType;
    private BigDecimal salaryFrom;
    private BigDecimal salaryTo;
}
