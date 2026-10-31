package com.example.session02.service;

import com.example.session02.model.EmployeeFilter;
import com.example.session02.model.entity.Employee;
import com.example.session02.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> searchByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> searchByFilter(EmployeeFilter filter){
        return employeeRepository.findByFilter(filter);
    }
}
