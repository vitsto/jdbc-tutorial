package com.skypro;

import com.skypro.dao.EmployeeDAO;
import com.skypro.dao.EmployeeDAOImpl;
import com.skypro.entity.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        System.out.println(employeeDAO.getEmployees());

        Employee test = new Employee("a", "aa", "f", 25, 7);
        employeeDAO.updateEmployee(1, test);
        System.out.println(employeeDAO.getEmployee(1));
        employeeDAO.deleteEmployee(20);
        System.out.println(employeeDAO.getEmployee(20));

    }
}
