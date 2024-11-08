package ru.rsreu.smartvacancy;

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
    public CommandLineRunner run(VacanciesFinder vacanciesFinder) {
        return (args -> {
            List<Vacancy> vacancies = vacanciesFinder.find().stream().limit(5).toList();
            vacancies.forEach(System.out::println);
        });
    }

}
