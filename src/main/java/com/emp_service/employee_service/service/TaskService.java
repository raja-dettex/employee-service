package com.emp_service.employee_service.service;

import com.emp_service.employee_service.dto.TaskDto;
import com.emp_service.employee_service.task.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.PriorityQueue;

@Service
public class TaskService {
    private final PriorityQueue<Task> queue = new PriorityQueue<>();
    private int count = 0;
    public Task getNextReadyTask() {
        Task task = queue.peek();
        if(task != null) {
            Instant now = Instant.now();
            if(now.isAfter(task.getFireTime()) || now.equals(task.getFireTime())) {
                return queue.poll();
            }
        }
        return null;
    }

    public int addTask(TaskDto dto) {
        Task task=  new Task(dto.getTimeInMinutes(), dto.getDeviceToken(), dto.getBundleId(), dto.getDeviceType(), dto.getMessage());
        task.setId(count++);
        this.queue.add(task);
        return task.getId();
    }

}