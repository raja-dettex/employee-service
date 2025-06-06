package com.emp_service.employee_service.service;

import com.emp_service.employee_service.dto.EmployeeUpdateDto;
import com.emp_service.employee_service.entity.Employee;
import com.emp_service.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee ) {
        var emp = this.employeeRepository.save(employee);
        this.employeeRepository.flush();
        return emp;
    }


    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Employee findById(int id) {
        return this.employeeRepository.findById(id).orElse(null);
    }
    public int delete(int id) throws  Exception{
        var emp = this.findById(id);
        if(emp.equals(null)) {
            throw new Exception("emp not found with id " + id);
        }
        this.employeeRepository.delete(emp);
        return id;
    }

    public int update(EmployeeUpdateDto dto) {
        return this.employeeRepository.updateEmployee(dto.getId(), dto.getName(), dto.getEmail(), dto.getMobile());
    }
}
