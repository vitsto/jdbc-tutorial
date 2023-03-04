package com.skypro;

import com.skypro.dao.EmployeeDAO;
import com.skypro.dao.EmployeeDAOImpl;
import com.skypro.entity.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "12345678";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee " +
                             "LEFT JOIN city on city.city_id = employee.city_id WHERE id = (?)")) {

            // Подставляем значение вместо wildcard
            statement.setInt(1, 10);

            // Делаем запрос к базе и результат кладем в ResultSet
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {
                // С помощью методов getInt и getString получаем данные из resultSet
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String city = resultSet.getString("city_name");

                int age = resultSet.getInt(5);

                // Выводим данные в консоль
                System.out.println("Имя: " + firstName + ", Фамилия: "
                        + lastName + ", Город: " + city + ", Возраст: " + age);

            }

            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            Employee employee = new Employee(12, "Denis", "Kim", "m", 29, 7);
            employeeDAO.createEmployee(employee);

            Employee employee1 = employeeDAO.getEmployee(2);
            System.out.println(employee1);

            List<Employee> employees = employeeDAO.getEmployees();
            System.out.println(employees);

            employeeDAO.updateEmployee(1, employee);
            employeeDAO.deleteEmployee(17);
            employeeDAO.deleteEmployee(18);
            employeeDAO.deleteEmployee(19);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
