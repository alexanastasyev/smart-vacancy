package ru.rsreu.smartvacancy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private List<ProgrammingLanguage> languages;
    private List<Technology> technologies;
    private Integer experienceMonths;
    private EmploymentType employmentType;
    private RemoteWorkType remoteWorkType;
    private BigDecimal salaryFrom;
    private BigDecimal salaryTo;
}
