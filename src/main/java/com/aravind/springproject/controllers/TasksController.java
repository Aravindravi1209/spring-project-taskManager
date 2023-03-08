package com.aravind.springproject.controllers;

import com.aravind.springproject.datas.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    ArrayList<Task> tasks;

    public TasksController(ArrayList<Task> tasks) {
        this.tasks = tasks;
        tasks.add(new Task("First Project",new Date(),false));
        tasks.add(new Task("Second Project",new Date(),true));
    }

    //List all tasks
    @GetMapping("")
    public ArrayList<Task> getAllTasks()
    {
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Integer id)
    {
        return tasks.get(id);
    }
}
