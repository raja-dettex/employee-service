package com.emp_service.employee_service.controller;


import com.emp_service.employee_service.dto.TaskDto;
import com.emp_service.employee_service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public String addTask(@RequestBody TaskDto dto) {
        int id  = this.taskService.addTask(dto);
        return "task added of ID: " + id;
    }
}
