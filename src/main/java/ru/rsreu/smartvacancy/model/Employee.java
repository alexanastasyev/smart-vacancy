package ru.rsreu.smartvacancy.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class Employee {
    private String name;
    private Set<ProgrammingLanguage> languages;
    private Set<Technology> technologies;
    private Integer experienceMonths;
    private EmploymentType employmentType;
    private RemoteWorkType remoteWorkType;
    private BigDecimal salaryFrom;
    private BigDecimal salaryTo;
}
