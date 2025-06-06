package com.emp_service.employee_service.dto;

import lombok.Data;

@Data
public class TaskDto {
    private int timeInMinutes;
    private String deviceToken;
    private String bundleId;
    private String deviceType;
    private String message;
}
