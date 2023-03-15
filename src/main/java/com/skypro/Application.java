package com.skypro;

import com.skypro.dao.CityDAO;
import com.skypro.dao.CityDAOImpl;
import com.skypro.dao.EmployeeDAO;
import com.skypro.dao.EmployeeDAOImpl;
import com.skypro.entity.City;
import com.skypro.entity.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDao = new CityDAOImpl();

//        City city1 = new City("Khabarovsk");
//        City city2 = new City("St. Peterburg");
//        City city3 = new City("New York");
        int cityId1 = 19;
        int cityId2 = 18;
        Employee employee1 = new Employee("Ivan", "Ivanov", "m", 35);
        Employee employee2 = new Employee("Maria", "Petrova", "f", 28);
        Employee employee3 = new Employee("John", "Dou", "m", 38);

        employeeDAO.addCity(cityId1, employee1);
        employeeDAO.addCity(cityId2, employee2);
        employeeDAO.addCity(cityId2, employee3);

//        employeeDAO.createEmployee(employee1);
//        Employee test = new Employee("a", "aa", "f", 25, 7);
//        employeeDAO.updateEmployee(1, test);
//        System.out.println(employeeDAO.getEmployee(1));
//        employeeDAO.deleteEmployee(20);
//        System.out.println(employeeDAO.getEmployee(20));

    }
}
