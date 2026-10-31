package com.example.session02.repository;

import com.example.session02.model.EmployeeFilter;
import com.example.session02.model.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        employees.add(new Employee(1L, "Nguyễn Văn A", "a@gmail.com", "IT"));
        employees.add(new Employee(2L, "Trần Thị B", "b@gmail.com", "HR"));
        employees.add(new Employee(3L, "Lê Văn C", "c@gmail.com", "Marketing"));

        employees.add(new Employee(4L, "Trương Nhân D", "d@gmail.com", "Sales"));
        employees.add(new Employee(5L, "Phạm Thu E", "e@gmail.com", "IT"));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    public Employee findById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Employee> findByName(String name) {
        return employees.stream().filter(e -> e.getFullName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public List<Employee> findByFilter(EmployeeFilter filter) {
        return employees.stream()
                .filter(e -> filter.getName()== null ||e.getFullName().toLowerCase().contains(filter.getName().toLowerCase()))
                .filter(e ->filter.getDepartment()==null || e.getDepartment().equalsIgnoreCase(filter.getDepartment()))
                .toList();
    }
}
