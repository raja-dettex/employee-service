package com.emp_service.employee_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq_generator")
    @SequenceGenerator(name = "emp_seq_generator", sequenceName = "EMP_SEQ", allocationSize = 10)
    private int id;
    private String name;
    private String email;
    private String password;
    private String mobile;
    private String department;
}
