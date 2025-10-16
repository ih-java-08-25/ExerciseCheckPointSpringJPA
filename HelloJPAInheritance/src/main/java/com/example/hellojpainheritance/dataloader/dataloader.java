package com.example.hellojpainheritance.dataloader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hellojpainheritance.*;
import com.example.hellojpainheritance.repository.*;
import com.example.hellojpainheritance.model.*;
import com.example.hellojpainheritance.enums.*;

import java.time.LocalDate;
import java.util.List;


@Configuration
public class dataloader {


    @Bean
    CommandLineRunner loadData(
            contactRepository contactRepo,
            AssociationRepository assocRepo,
            ConferenceRepository confRepo
    ) {
        return args -> {

            // PR Contact Example
            Name name = new Name();
            name.setSalutation("Dr.");
            name.setFirstName("Maria");
            name.setLastName("Lopez");

            Contact contact = new Contact();
            contact.setCompany("MediaWorks");
            contact.setTitle("PR Consultant");
            contact.setName(name);
            contactRepo.save(contact);

            // Nurse Association Example
            Member pres = new Member();
            pres.setName("Ana Rivera");
            pres.setStatus(MemberStatus.ACTIVE);
            pres.setRenewalDate(LocalDate.now());

            Division div = new Division();
            div.setName("North Division");
            div.setDistrict("Madrid");
            div.setPresident(pres);
            div.setMembers(List.of(pres));

            Association assoc = new Association();
            assoc.setName("Nurse Association of Spain");
            assoc.setDivisions(List.of(div));

            assocRepo.save(assoc);

            // Event Example
            Guest guest = new Guest();
            guest.setName("Tom Hardy");
            guest.setStatus(GuestStatus.ATTENDING);

            Speaker speaker = new Speaker();
            speaker.setName("Dr. Simon King");
            speaker.setPresentationDuration(45);

            Conference conf = new Conference();
            conf.setTitle("Health Tech Summit");
            conf.setDate(LocalDate.of(2025, 10, 5));
            conf.setDuration(3);
            conf.setLocation("Barcelona");
            conf.setGuests(List.of(guest));

            confRepo.save(conf);
        };
    }
}
