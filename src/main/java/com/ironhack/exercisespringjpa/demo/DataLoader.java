package com.ironhack.exercisespringjpa.demo;

import com.ironhack.exercisespringjpa.enums.Position;
import com.ironhack.exercisespringjpa.model.Footballer;
import com.ironhack.exercisespringjpa.service.FootballerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    public final FootballerService footballerService;

    public DataLoader(FootballerService footballerService) {
        this.footballerService = footballerService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading inital data..");
        if (!footballerService.getAll().isEmpty()) {
            System.out.println("Data already loaded, skipping....");
            return;
        }
        Footballer footballer1 = new Footballer("Luka Modric", 40, "Croatian",
                "A.C. Milan", Position.MIDFIELDER);
        Footballer footballer2 = new Footballer("Florian Wirtz", 22, "German",
                "Liverpool FC", Position.MIDFIELDER);
        Footballer footballer3 = new Footballer("Dani Olmo", 27, "Spanish",
                "Barcelona", Position.MIDFIELDER);
        footballerService.create(footballer1);
        footballerService.create(footballer2);
        footballerService.create(footballer3);
        System.out.println("Data loaded!");
    }

}
