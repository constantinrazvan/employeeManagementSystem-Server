package com.razvanConstantin.employeeManagementSystem.Repository;

import com.razvanConstantin.employeeManagementSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> getEmployeesByName(String name);
}
