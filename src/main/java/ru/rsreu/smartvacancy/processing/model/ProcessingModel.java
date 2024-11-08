package ru.rsreu.smartvacancy.processing.model;

import java.util.Map;

public record ProcessingModel<T>(
        T entityKey,
        Map<String, Double> processingValues
) {
}
