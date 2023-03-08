package com.aravind.springproject.controllers;

import com.aravind.springproject.datas.Task;
import org.springframework.web.bind.annotation.*;

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

    //create a task
    @PostMapping("")
    public void addTask(@RequestBody Task task)
    {
        tasks.add(task);
    }

    @PutMapping("/{id}")
    public void updateTaskCompletely(@PathVariable("id") Integer id, @RequestBody Task task)
    {
        tasks.set(id,task);
    }

    @PatchMapping("/{id}")
    public void updateTaskPartly(@PathVariable("id") Integer id, @RequestBody Task task)
    {
        Task currTask = tasks.get(id);

        if(task.getTitle()!=null && !task.getTitle().isEmpty())
        {
            currTask.setTitle(task.getTitle());
        }
        if(task.getDueDate()!=null)
        {
            currTask.setDueDate(task.getDueDate());
        }
        if(task.isCompleted()==true || task.isCompleted()==false)
        {
            currTask.setCompleted(task.isCompleted());
        }

        tasks.set(id,currTask);
    }

    @RequestMapping("/{id}")
    public void deleteTask(@PathVariable("id") Integer id)
    {
        tasks.remove((int)id);
    }
}
