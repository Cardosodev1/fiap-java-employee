package br.com.fiap.dao;

import br.com.fiap.entity.Employee;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface IEmployeeDao {

    void register(Employee employee);

    void update(Employee employee) throws IdNotFoundException;

    void remove(Integer id) throws IdNotFoundException;

    Employee searchById(int id) throws IdNotFoundException;

    void commit() throws CommitException;
}
