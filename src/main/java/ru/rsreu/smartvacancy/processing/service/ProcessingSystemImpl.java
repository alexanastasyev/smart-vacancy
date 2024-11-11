package ru.rsreu.smartvacancy.processing.service;

import ru.rsreu.smartvacancy.processing.api.ProcessingSystem;
import ru.rsreu.smartvacancy.processing.model.ProcessingModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ProcessingSystemImpl<T> implements ProcessingSystem<T> {
    private final List<ProcessingModel<T>> models = new ArrayList<>();

    @Override
    public void inputModels(List<ProcessingModel<T>> models) {
        this.models.clear();
        this.models.addAll(models);
    }

    @Override
    public void normalize() {
        models.get(0).processingValues().forEach((key, value) -> normalizeField(key));
    }

    @Override
    public List<T> findSimilar(T target, int limit) {
        ProcessingModel<T> targetModel = models.stream()
                .filter(m -> m.entity().equals(target))
                .findFirst()
                .orElseThrow();

        List<DistanceDto<T>> distances = new ArrayList<>();
        models.forEach(m -> {
            if (m != targetModel) {
                double distance = calculateDistance(targetModel, m);
                distances.add(new DistanceDto<>(m.entity(), distance));
            }
        });

        return distances.stream()
                .sorted(Comparator.comparingDouble(DistanceDto::distance))
                .map(DistanceDto::entity)
                .limit(limit)
                .toList();
    }

    private void normalizeField(String fieldName) {
        double min = findMinValue(fieldName);
        double max = findMaxValue(fieldName);
        for (ProcessingModel<T> model : models) {
            double current = model.processingValues().get(fieldName);
            double newValue = max == min ? 0d : (current - min) / (max - min);
            model.processingValues().put(fieldName, newValue);
        }
    }

    private double findMaxValue(String fieldName) {
        double current = models.get(0).processingValues().get(fieldName);
        for (ProcessingModel<T> model : models) {
            if (model.processingValues().get(fieldName) > current) {
                current = model.processingValues().get(fieldName);
            }
        }
        return current;
    }

    private double findMinValue(String fieldName) {
        double current = models.get(0).processingValues().get(fieldName);
        for (ProcessingModel<T> model : models) {
            if (model.processingValues().get(fieldName) < current) {
                current = model.processingValues().get(fieldName);
            }
        }
        return current;
    }

    private double calculateDistance(ProcessingModel<T> model1, ProcessingModel<T> model2) {
        double sum = 0;
        Set<String> keys = model1.processingValues().keySet();
        for (String key : keys) {
            sum += sqrDiff(model1.processingValues().get(key), model2.processingValues().get(key));
        }
        return Math.sqrt(sum);
    }

    private double sqrDiff(double value1, double value2) {
        return Math.pow(value1 - value2, 2);
    }

    private record DistanceDto<T> (T entity, double distance) {}
}
