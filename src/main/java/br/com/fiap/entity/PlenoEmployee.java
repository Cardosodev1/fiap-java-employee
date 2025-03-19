package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Pleno_Employee")
public class PlenoEmployee extends Employee {

    private static final double BONUS_PER_15_HOURS = 250.0;

    public PlenoEmployee() {
    }

    public PlenoEmployee(String firstName, String lastName, Double hoursWorked, Double paidByHours) {
        super(firstName, lastName, hoursWorked, paidByHours);
    }

    @Override
    public Double calculateSalary() {
        double baseSalary = super.calculateSalary();
        double bonus = (getHoursWorked() / 15) * BONUS_PER_15_HOURS;
        return baseSalary + bonus;
    }

    @Override
    public void printInformation() {
        super.printInformation();
        System.out.printf("Bonus: %.2f%n", (getHoursWorked() / 15) * BONUS_PER_15_HOURS);
        System.out.println("Employee Type: Pleno");
    }
}
