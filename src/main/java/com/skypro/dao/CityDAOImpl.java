package com.skypro.dao;

import com.skypro.HibernateManager;
import com.skypro.entity.City;
import com.skypro.entity.Employee;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    private HibernateManager hibernateManager = HibernateManager.getInstance();
    private volatile City city;
    private volatile List<City> cityList;

    @Override
    public void createCity(City city) {
        hibernateManager.withEntityManager(em -> {
            em.persist(city);
        });
    }

    @Override
    public City getCity(int id) {
        hibernateManager.withEntityManager(em -> {
            city = em.find(City.class, id);
        });
        return city;
    }

    @Override
    public List<City> getCities() {
        hibernateManager.withEntityManager(em -> {
            cityList = em.createQuery("SELECT city FROM City city").getResultList();
        });
        return cityList;
    }

    @Override
    public void updateCity(int id, City newCity) {
        hibernateManager.withEntityManager(em -> {
            city = em.find(City.class, id);

            newCity.setCityId(city.getCityId());
            em.persist(newCity);
//            employee.setFirstName(newEmployee.getFirstName());
//            employee.setLastName(newEmployee.getLastName());
//            employee.setAge(newEmployee.getAge());
//            employee.setGender(newEmployee.getGender());
//            employee.setCity(newEmployee.getCity());
//
//            em.persist(employee);
        });
    }

    @Override
    public void deleteCity(int id) {
        hibernateManager.withEntityManager(em -> {
            em.remove(em.find(City.class, id));
        });
    }
}
