package com.example.Company.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Company.Models.Employee;
import com.example.Company.Repositories.EmployeeRepository;


public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

}
