package br.com.fiap.entity;

import javax.persistence.*;

@Entity
@Table(name="TB_EMPLOYEE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE", discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(name="employee", sequenceName = "SQ_TB_EMPLOYEE", allocationSize = 1)
public class Employee {

    @Id
    @Column(name="id_employee")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee")
    private Integer id;

    @Column(name="fs_name", nullable = false, length = 100)
    private String firstName;

    @Column(name="ls_name", nullable = false, length = 100)
    private String lastName;

    @Column(name="hr_worked", precision = 10, scale = 2)
    private Double hoursWorked;

    @Column(name="pd_hours", precision = 10, scale = 2)
    private Double paidByHours;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Double hoursWorked, Double paidByHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.paidByHours = paidByHours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Double getPaidByHours() {
        return paidByHours;
    }

    public void setPaidByHours(Double paidByHours) {
        this.paidByHours = paidByHours;
    }

    public Double calculateSalary() {
        return hoursWorked * paidByHours;
    }

    public void printInformation() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Paid by Hour: " + paidByHours);
        System.out.printf("Total Salary: %.2f%n%n", calculateSalary());
    }
}
