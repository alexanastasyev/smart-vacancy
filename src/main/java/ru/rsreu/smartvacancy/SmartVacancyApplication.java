package ru.rsreu.smartvacancy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.rsreu.smartvacancy.domain.model.Vacancy;
import ru.rsreu.smartvacancy.domain.processing.VacanciesFinder;

import java.util.List;

@SpringBootApplication
public class SmartVacancyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartVacancyApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(VacanciesFinder vacanciesFinder, ObjectMapper objectMapper) {
        return (args -> {
            List<Vacancy> vacancies = vacanciesFinder.find(5);
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(vacancies));
        });
    }

}
