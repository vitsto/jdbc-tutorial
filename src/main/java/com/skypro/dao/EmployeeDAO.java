package com.skypro.dao;

import com.skypro.entity.City;
import com.skypro.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void createEmployee(Employee employee);

    Employee getEmployee(int id);

    List<Employee> getEmployees();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);

    void addCity(int cityId, Employee employee);

}
