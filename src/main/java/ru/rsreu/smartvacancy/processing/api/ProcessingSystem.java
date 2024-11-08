package ru.rsreu.smartvacancy.processing.api;

import ru.rsreu.smartvacancy.processing.model.ProcessingModel;

import java.util.List;

public interface ProcessingSystem<T> {
    /**
     * Загружает список моделей в систему
     * @param models Список моделей
     */
    void inputModels(List<ProcessingModel<T>> models);

    /**
     * Произвести нормализацию существующих значений
     */
    void normalize();

    /**
     * Ищет похожие объекты и возвращает их списком в порядке схожести
     * @param target Целевой объект
     * @param limit количество искомых обхектов
     * @return Список объектов
     */
    List<T> findSimilar(T target, int limit);
}
