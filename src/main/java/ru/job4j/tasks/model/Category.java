package ru.job4j.tasks.model;

public class Category {

    private int id;

    private String name;

    public static Category of(int id, String name) {
        Category category = new Category();
        category.id = id;
        category.name = name;
        return category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
