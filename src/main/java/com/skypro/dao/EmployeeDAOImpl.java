package com.skypro.dao;

import com.skypro.HibernateManager;
import com.skypro.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private HibernateManager hibernateManager = new HibernateManager();
    private volatile Employee employee;
    private volatile List<Employee> employeeList;

    public EmployeeDAOImpl() {

    }

    @Override
    public void createEmployee(Employee employee) {
        hibernateManager.withEntityManager(em -> {
            em.persist(employee);
        });
    }

    @Override
    public Employee getEmployee(int id) {
        hibernateManager.withEntityManager(em -> {
            employee = em.find(Employee.class, id);
        });
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        hibernateManager.withEntityManager(em -> {
            employeeList = em.createQuery("SELECT employee FROM Employee employee").getResultList();
        });
        return employeeList;
    }

    @Override
    public void updateEmployee(int id, Employee newEmployee) {
        hibernateManager.withEntityManager(em -> {
            employee = em.find(Employee.class, id);

            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setAge(newEmployee.getAge());
            employee.setGender(newEmployee.getGender());
            employee.setCityId(newEmployee.getCityId());

            em.persist(employee);
        });
    }

    @Override
    public void deleteEmployee(int id) {
        hibernateManager.withEntityManager(em -> {
            em.remove(em.find(Employee.class, id));
        });
//        try(PreparedStatement statement = connection.prepareStatement(
//                "DELETE FROM employee WHERE id=(?)")) {
//
//            statement.setInt(1, id);
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
