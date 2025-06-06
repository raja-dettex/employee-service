package com.emp_service.employee_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployeeUpdateDto {
    private int id;
    private String name;
    private String email;
    private String mobile;


}
