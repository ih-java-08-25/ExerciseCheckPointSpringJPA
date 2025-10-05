package com.ironhack.exercisespringjpa.model;

import com.ironhack.exercisespringjpa.enums.Position;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "footballer")
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name", nullable = false,length = 200)
    private String name;
    private int age;
    @Column(name = "nationality", nullable = false)
    private String nationality;
    @Column(name = "currentTeam", nullable = false)
    private String currentTeam;
    @Enumerated(EnumType.STRING)
    private Position position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Footballer(String name, int age, String nationality, String currentTeam, Position position) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.currentTeam = currentTeam;
        this.position = position;
    }

    public Footballer() {
    }

    @Override
    public String toString() {
        return "Footballer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", currentTeam='" + currentTeam + '\'' +
                ", position=" + position +
                '}';
    }
}
