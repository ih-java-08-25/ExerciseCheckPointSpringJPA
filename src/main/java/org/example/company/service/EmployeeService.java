package org.example.company.service;


import org.example.company.model.Employee;
import org.example.company.model.Engineer;
import org.example.company.model.Manager;
import org.springframework.stereotype.Service;
import org.example.company.repository.EmployeeRepository;
import org.example.company.repository.EngineerRepository;
import org.example.company.repository.ManagerRepository;

import java.util.*;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
public  List<Employee> findAll(){
    return employeeRepository.findAll();
}
public Employee save(Employee employee){
        return employeeRepository.save(employee);
}
public void deleteById(Long id){
        employeeRepository.deleteById(id);
}
public List<Employee>findBySalaryGreaterThan(double salary){
    return employeeRepository.findBySalaryGreaterThan(salary);
}
public List<Employee>findByNameStartingWith(String prefix){
    return employeeRepository.findByNameStartingWith(prefix);
}
public List<String>findEmployeesAboveAverageSalary(){
        return employeeRepository.findEmployeesAboveAverageSalary();
}
public List<Employee>findTop3ByByHighestSalary(){
        return employeeRepository.findTop3ByHighestSalary();

}
public List<Employee>findByName(String name){
        return employeeRepository.findByName(name);
}
}
