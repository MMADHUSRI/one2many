package com.example.one2many.controller;

import com.example.one2many.models.Department;
import com.example.one2many.repository.DepartmentRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    public DepartmentRepository repository;
    @GetMapping
    public List<Department> getAllDepartment(){
    return repository.findAll();
    }
    @PostMapping
    public String insertDepartment(@RequestBody Department department){
        repository.save(department);
        return "Department added";

    }
    @PutMapping("/{id}")
    public String updateDepartment(@PathVariable long id,@RequestBody Department department) {
        Optional<Department> department1 = repository.findById(id);
        if (department1.isPresent()) {
           department1.get().setName(department.getName());
           department1.get().setEmployees(department.getEmployees());
           repository.save(department1.get());

        }
        return "Department updated";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id ){
        repository.deleteById(id);
        return "Deleted";
    }
}
