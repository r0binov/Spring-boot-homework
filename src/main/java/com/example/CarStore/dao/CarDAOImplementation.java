package com.example.CarStore.dao;

import com.example.CarStore.model.Car;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAOImplementation implements CarDAO {

    private final EntityManager entityManager;

    @Autowired
    public CarDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Car> req = currentSession.createQuery("FROM Car", Car.class);

        return req.getResultList();
    }

    @Override
    public Car findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Car.class, id);
    }

    @Override
    public void addCar(Car car) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(car);
    }
}