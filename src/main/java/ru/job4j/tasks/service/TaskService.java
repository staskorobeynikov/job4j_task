package ru.job4j.tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.tasks.model.Category;
import ru.job4j.tasks.model.Task;
import ru.job4j.tasks.repository.TaskRepositoryMem;

import java.util.Collection;

@Service
public class TaskService {

    private final TaskRepositoryMem storage;

    @Autowired
    public TaskService(TaskRepositoryMem storage) {
        this.storage = storage;
    }

    public Collection<Task> findAllTasks() {
        return storage.findAll();
    }

    public Collection<Category> findAllCategories() {
        return storage.findAllCategories();
    }

    public Task save(Task task, String id) {
        return storage.save(task, Integer.parseInt(id));
    }
}
