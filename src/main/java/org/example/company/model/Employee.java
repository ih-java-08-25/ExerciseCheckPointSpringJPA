package org.example.company.model;
import jakarta.persistence.Inheritance;
import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    public Employee() {}

public Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
}
public Long getId() {
        return id;
}
public String getName() {
        return name;
}
public double getSalary() {
        return salary;
}
public void setId(Long id) {
        this.id = id;
}
public void setName(String name) {
        this.name = name;
}
public void setSalary(double salary) {
        this.salary = salary;
}




}