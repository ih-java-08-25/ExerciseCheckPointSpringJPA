package com.example.CupcakeStore;

import com.example.CupcakeStore.Model.Cupcakes;
import com.example.CupcakeStore.Model.Orders;
import com.example.CupcakeStore.Service.CupcakeService;
import com.example.CupcakeStore.Service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CupcakeStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CupcakeStoreApplication.class, args);
	}


    @Bean
    CommandLineRunner run(CupcakeService cupcakeService, OrderService orderService) {
        return args -> {

            // Create cupcakes
            Cupcakes chocolate = cupcakeService.saveCupcake(new Cupcakes("Chocolate Delight", "Chocolate", new BigDecimal("3.50")));
            Cupcakes vanilla = cupcakeService.saveCupcake(new Cupcakes("Vanilla Dream", "Vanilla", new BigDecimal("3.00")));
            Cupcakes strawberry = cupcakeService.saveCupcake(new Cupcakes("Strawberry Surprise", "Strawberry", new BigDecimal("3.75")));

            // Create orders
            orderService.saveOrder(new Orders("Alice", chocolate, 2));
            orderService.saveOrder(new Orders("Bob", vanilla, 1));
            orderService.saveOrder(new Orders("Charlie", strawberry, 3));
            orderService.saveOrder(new Orders("Alice", strawberry, 1));
        };
    }
}
