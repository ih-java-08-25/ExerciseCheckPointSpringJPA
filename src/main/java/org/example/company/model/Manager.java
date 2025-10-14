package org.example.company.model;
import jakarta.persistence.Entity;


@Entity
public class Manager extends Employee {
    private double bonus;
    private int teamSize;

    public Manager() {}

    public Manager(String name, double salary, int teamSize, double bonus) {
        super(name, salary);
        this.bonus = bonus;
        this.teamSize = teamSize;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
