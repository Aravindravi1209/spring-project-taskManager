package com.aravind.springproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController1 {
    @GetMapping("/hello")
    public String hello()
    {
        return "Hello <H1>World!</H1>";
    }
}
