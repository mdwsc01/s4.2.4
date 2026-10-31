package com.example.session02.controller;

import com.example.session02.model.EmployeeFilter;
import com.example.session02.model.entity.Employee;
import com.example.session02.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/search")
    public List<Employee> getEmployeesByName(@RequestParam String name){
        return employeeService.searchByName(name);
    }

    @GetMapping("/filter")
    public List<Employee> filterEmployees(@ModelAttribute EmployeeFilter filter){
        return employeeService.searchByFilter(filter);
    }
}
