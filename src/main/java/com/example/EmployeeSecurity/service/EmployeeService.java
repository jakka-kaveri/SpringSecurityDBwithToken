package com.example.EmployeeSecurity.service;

import com.example.EmployeeSecurity.entity.Employee;
import com.example.EmployeeSecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> displayAll(){
        return repository.findAll();
    }

    public void register(Employee emp){
        repository.save(emp);
    }

    public Employee getDetails(String name) {
        return repository.findByName(name);
    }
    public void deleting(int id){
        repository.deleteById(id);
    }

}
