package com.emp_service.employee_service.repository;

import com.emp_service.employee_service.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.name = :name, e.email = :email, e.mobile = :mobile WHERE e.id = :id")
    int updateEmployee(@Param("id") int id, @Param("name") String name, @Param("email") String email,  @Param("mobile") String mobile);
}
