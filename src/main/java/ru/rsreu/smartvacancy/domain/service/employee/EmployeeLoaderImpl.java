package ru.rsreu.smartvacancy.domain.service.employee;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import ru.rsreu.smartvacancy.domain.model.Employee;

@Component
@RequiredArgsConstructor
public class EmployeeLoaderImpl implements EmployeeLoader {

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Override
    @SneakyThrows
    public Employee loadEmployee() {
        Resource resource = resourceLoader.getResource("classpath:employee.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }
}
