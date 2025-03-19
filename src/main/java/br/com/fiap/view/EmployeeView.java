package br.com.fiap.view;

import br.com.fiap.dao.EmployeeDao;
import br.com.fiap.entity.Employee;
import br.com.fiap.exception.IdNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeView {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EMPLOYEE_ORACLE");
        EntityManager em = emf.createEntityManager();
        EmployeeDao dao = new EmployeeDao(em);
        Employee employee = new Employee("Guilherme", "Cardoso", 176.0, 20.0);

        //Register an Employee (CREATE -> INSERT)
        try {
            dao.register(employee);
            dao.commit();
            System.out.println("\n*** Registered employee ***");
            employee.printInformation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Search for an Employee (READ -> SELECT)
        try {
            dao.searchById(employee.getId());
            System.out.println("*** Employee found ***");
            employee.printInformation();
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Update a Client (UPDATE -> UPDATE)
        try {
            employee.setFirstName("João");
            employee.setLastName("Motta");
            dao.update(employee);
            dao.commit();
            System.out.println("\n*** Updated employee ***");
            employee.printInformation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Remove a Client (DELETE -> DELETE)
        try {
            dao.remove(employee.getId());
            dao.commit();
            System.out.println("\n*** Employee Removed ***");
            employee.printInformation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
