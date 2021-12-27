package ru.job4j.tasks.model;

public class Task {

    private int id;

    private String description;

    private Category category;

    public static Task of(int id, String description, Category category) {
        Task task = new Task();
        task.id = id;
        task.description = description;
        task.category = category;
        return task;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
