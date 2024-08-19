package com.example.Employeee.service;

import com.example.Employeee.model.Employee;
import com.example.Employeee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id)
    {
        return employeeRepository.findById(id);
    }
    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public Employee updateDetails(Long id,Employee employeeDetails)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setName(employeeDetails.getName());
        employee.setDepartment(employeeDetails.getDepartment());
        return employeeRepository.save(employee);
    }
    public void deleteById(Long id)
    {
        employeeRepository.deleteById(id);
    }

}

