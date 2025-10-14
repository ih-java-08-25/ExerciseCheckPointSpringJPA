package org.example.company.controller;


import org.example.company.model.Employee;
import org.example.company.model.Engineer;
import org.example.company.model.Manager;
import org.example.company.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;

    }
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.findAll();
    }
    @PostMapping
    public Employee create (@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
    }
    @GetMapping("/salary/{amount}")
    public List<Employee>salaryGreater(@PathVariable double amount){
        return employeeService.findBySalaryGreaterThan(amount);
    }
    @GetMapping("/name/{name}")
    public List<Employee> byName(@PathVariable String name){
        return employeeService.findByName(name);

    }
    @GetMapping("/prefix/{prefix}")
    public List<Employee> byPrefix(@PathVariable String prefix){
        return employeeService.findByNameStartingWith(prefix);
    }
    @GetMapping("/above-average")
    public List<String> aboveAverage(){
        return employeeService.findEmployeesAboveAverageSalary();
    }
    @GetMapping("/top3")
    public List<Employee> top3(){
        return employeeService.findTop3ByByHighestSalary();
    }








}
