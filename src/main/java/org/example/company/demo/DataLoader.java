package org.example.company.demo;


import org.example.company.model.*;
import org.example.company.repository.EmployeeRepository;
import org.example.company.repository.EngineerRepository;
import org.example.company.repository.ManagerRepository;
import org.example.company.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;
    private final EngineerRepository engineerRepository;
    private final UserProfileRepository userProfileRepository;


    public DataLoader(EmployeeRepository employeeRepository, ManagerRepository managerRepository, EngineerRepository engineerRepository, UserProfileRepository userProfileRepository       ) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
        this.engineerRepository = engineerRepository;
        this.userProfileRepository = userProfileRepository;
    }
    @Override
    public void run(String... args) {
        System.out.println("Loading employee data...");
      employeeRepository.saveAll(List.of(
                new Employee("BOB", 4000),
                new Employee("JACK", 6000),
                new Employee("MIKE", 1000),
                new Employee("ROB", 7000)
                ));

        managerRepository.saveAll(List.of(
                new Manager("Oktawia",7000, 2, 1500 ),
                new Manager("Oleg", 6500, 5,2000 )
        ));
        engineerRepository.saveAll(List.of(
                new Engineer("David", 3500,"QAtester" ),
                new Engineer("Ira", 4000, "DevOPS")
        ));
        userProfileRepository.saveAll(List.of(
                new UserProfile(new ContactInfo("BOB@mail.com","111-222"),
                new EmergencyContact("BOB.sosmail.com", "999-777")),
                new UserProfile(new ContactInfo("JACK@mail.com","333-444"),
                        new EmergencyContact("Jack.sosmail.com", "123-567"))
        ));
        System.out.println("Employee data loaded successfully");

    }
}
