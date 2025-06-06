package com.emp_service.employee_service.task;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Comparator;

@Component
@NoArgsConstructor
@Data
public class Task implements Comparable<Task> {
    private int id;
    private int timeInMinutes;
    private String deviceToken;
    private String bundleId;
    private String deviceType;
    private String message;
    private Instant fireTime;

    public Task(int timeInMinutes, String deviceToken, String bundleId, String deviceType, String message) {
        this.timeInMinutes = timeInMinutes;
        this.deviceToken = deviceToken;
        this.bundleId = bundleId;
        this.deviceType = deviceType;
        this.message = message;
        // Calculate fireTime when the task is created/added
        this.fireTime = Instant.now().plusSeconds(timeInMinutes * 60L);
    }
    @Override
    public int compareTo(Task otherTask) {
        return this.fireTime.compareTo(otherTask.fireTime);
    }
}
