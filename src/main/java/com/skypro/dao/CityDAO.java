package com.skypro.dao;

import com.skypro.entity.City;
import com.skypro.entity.Employee;

import java.util.List;

public interface CityDAO {
    void createCity(City city);

    City getCity(int id);

    List<City> getCities();

    void updateCity(int id, City city);

    void deleteCity(int id);
}
