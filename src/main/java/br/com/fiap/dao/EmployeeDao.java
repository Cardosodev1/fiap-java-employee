package br.com.fiap.dao;

import br.com.fiap.entity.Employee;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

import javax.persistence.EntityManager;

public class EmployeeDao implements IEmployeeDao {

    private EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public void register(Employee employee) {
        em.persist(employee);
    }

    @Override
    public void update(Employee employee) throws IdNotFoundException {
        searchById(employee.getId());
        em.merge(employee);
    }

    @Override
    public void remove(Integer id) throws IdNotFoundException {
        Employee employee = searchById(id);
        em.remove(employee);
    }

    @Override
    public Employee searchById(int id) throws IdNotFoundException {
        Employee employee = em.find(Employee.class, id);
        if (employee == null)
            throw new IdNotFoundException("Employee not found");
        return employee;
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
