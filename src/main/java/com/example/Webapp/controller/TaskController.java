package com.example.Webapp.controller;

import com.example.Webapp.model.Task;
import com.example.Webapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // Display all tasks
    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    // Show the form to create a new task
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    // Handle the form submission to create a new task with validation
    @PostMapping
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "task-form";
        }
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    // Handle the form submission to update an existing task with validation
    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, @Valid @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "task-form";
        }
        task.setId(id);
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    // Other methods remain unchanged
}
