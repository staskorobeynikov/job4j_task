package ru.job4j.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.tasks.model.Task;
import ru.job4j.tasks.service.TaskService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/task")
    public String getAll(Model model) {
        model.addAttribute("tasks", service.findAllTasks());
        model.addAttribute("categories", service.findAllCategories());
        return "task";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Task task, HttpServletRequest req) {
        service.save(task, req.getParameter("category.id"));
        return "redirect:/task";
    }
}
