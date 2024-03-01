package com.razvanConstantin.employeeManagementSystem.Service;

import com.razvanConstantin.employeeManagementSystem.Entity.Employee;
import com.razvanConstantin.employeeManagementSystem.Repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee postEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployeeById(Long id) {
        if(!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee with id " + id + " does not exist");
        }

        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();

            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setEmail(employeeDetails.getEmail());
            existingEmployee.setPhone(employeeDetails.getPhone());
            existingEmployee.setDepartment(employeeDetails.getDepartment());
            return employeeRepository.save(existingEmployee);
        }

        return null;
    }


    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.getEmployeesByName(name);
    }
}
