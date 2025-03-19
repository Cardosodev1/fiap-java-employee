package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Senior_Employee")
public class SeniorEmployee extends Employee {

    private static final double BONUS_PER_15_HOURS = 500.0;

    public SeniorEmployee() {
    }

    public SeniorEmployee(String firstName, String lastName, Double hoursWorked, Double paidByHours) {
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
        System.out.println("Employee Type: Senior");
    }
}
