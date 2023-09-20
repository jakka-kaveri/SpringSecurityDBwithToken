package com.example.EmployeeSecurity.controller;

import com.example.EmployeeSecurity.entity.Employee;
import com.example.EmployeeSecurity.repository.EmployeeRepository;
import com.example.EmployeeSecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService service;


    @GetMapping("/employeeInfo/{name}")
    public ResponseEntity<Employee> getDetails(@PathVariable String name) {
        Employee employee = employeeRepository.findByName(name);

        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerEmp(@RequestBody Employee emp) {
       service.register(emp);
        return ResponseEntity.ok("Registration successful!");
    }

    @GetMapping("/displayAll")
    public ResponseEntity<List<Employee>> displayAllEmployees() {
        // Allow access to everyone to display all employees
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/d/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable int id){
        service.deleting(id);
        return ResponseEntity.ok("Deleted empleyee with ID "+id );
    }
}
