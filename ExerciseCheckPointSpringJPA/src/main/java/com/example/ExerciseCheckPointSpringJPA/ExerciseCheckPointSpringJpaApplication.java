package com.example.ExerciseCheckPointSpringJPA;

import com.example.ExerciseCheckPointSpringJPA.Models.Customer;
import com.example.ExerciseCheckPointSpringJPA.Models.Orders;
import com.example.ExerciseCheckPointSpringJPA.Repositories.CustomerRepository;
import com.example.ExerciseCheckPointSpringJPA.Repositories.OrdersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExerciseCheckPointSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseCheckPointSpringJpaApplication.class, args);
	}

    @Bean
    CommandLineRunner run(CustomerRepository customerRepo, OrdersRepository orderRepo) {
        return args -> {
            // Create Customers
            Customer alice = customerRepo.save(new Customer("Alice", "Wonderland", 28));
            Customer bob = customerRepo.save(new Customer("Bob", "Marley", 35));
            Customer charlie = customerRepo.save(new Customer("Charlie", "Chaplin", 40));
            Customer diana = customerRepo.save(new Customer("Diana", "Prince", 30));
            Customer ethan = customerRepo.save(new Customer("Ethan", "Hunt", 38));

            // Create Orders
            orderRepo.save(new Orders(5, 1));
            orderRepo.save(new Orders(10, 2));
            orderRepo.save(new Orders(3, 3));
            orderRepo.save(new Orders(7, 4));
            orderRepo.save(new Orders(12, 5));
        };
    }
}
