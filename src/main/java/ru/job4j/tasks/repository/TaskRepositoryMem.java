package ru.job4j.tasks.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.tasks.model.Category;
import ru.job4j.tasks.model.Task;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TaskRepositoryMem {
    private final Map<Integer, Task> tasks = new ConcurrentHashMap<>();

    private static final AtomicInteger TASK_ID = new AtomicInteger(4);

    private final Map<Integer, Category> categories = new ConcurrentHashMap<>();

    public TaskRepositoryMem() {
        Category first = Category.of(1, "Category_1");
        Category second = Category.of(2, "Category_2");
        Category third = Category.of(3, "Category_3");

        categories.put(1, first);
        categories.put(2, second);
        categories.put(3, third);

        tasks.put(1, Task.of(1, "Description_1", first));
        tasks.put(2, Task.of(2, "Описание_2", second));
        tasks.put(3, Task.of(3, "Description_3", third));
    }

    public Collection<Task> findAll() {
        return tasks.values();
    }

    public Collection<Category> findAllCategories() {
        return categories.values();
    }

    public Task save(Task task, int id) {
        task.setId(TASK_ID.incrementAndGet());
        task.setCategory(categories.get(id));
        tasks.put(task.getId(), task);
        return task;
    }
}
