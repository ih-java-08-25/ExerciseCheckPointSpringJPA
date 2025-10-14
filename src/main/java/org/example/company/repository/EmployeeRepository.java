package org.example.company.repository;
import org.example.company.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findByNameStartingWith(String prefix);

    @Query("SELECT e.name FROM Employee e WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)")
    List<String> findEmployeesAboveAverageSalary();

    @Query(value = "SELECT * FROM employee ORDER BY salary DESC LIMIT 3", nativeQuery = true)
    List<Employee> findTop3ByHighestSalary();
}
