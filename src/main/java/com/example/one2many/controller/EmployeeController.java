package com.example.one2many.controller;

import com.example.one2many.models.Employee;
import com.example.one2many.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public EmployeeRepository repository;
    @GetMapping
    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }
    @PostMapping
    public String insetEmployee(@RequestBody Employee employee){
        repository.save(employee);
        return "Employee added";

    }
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        Optional<Employee>employee1=repository.findById(id);
        if(employee1.isPresent()){
            employee1.get().setName(employee.getName());
            employee1.get().setDepartment(employee.getDepartment());
        }
        return "updated...";


    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable long id){
        repository.deleteById(id);
        return "Deleted..";
    }
}
