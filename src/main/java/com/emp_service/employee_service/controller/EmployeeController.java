package com.emp_service.employee_service.controller;

import com.emp_service.employee_service.dto.EmployeeUpdateDto;
import com.emp_service.employee_service.entity.Employee;
import com.emp_service.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeService.getAll();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody  Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return this.employeeService.findById(id);
    }

    @PutMapping("/update")
    public int  updateEmployee(@RequestBody EmployeeUpdateDto dto) {
        return this.employeeService.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteEmployee(@PathVariable int id) throws Exception{
        return this.employeeService.delete(id);
    }
}
