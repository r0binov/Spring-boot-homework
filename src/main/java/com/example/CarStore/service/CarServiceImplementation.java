package com.example.CarStore.service;

import com.example.CarStore.dao.CarDAOImplementation;
import com.example.CarStore.model.Car;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImplementation implements CarService {

    private CarDAOImplementation carDaoImplementation;

    @Autowired
    public CarServiceImplementation(CarDAOImplementation carDaoImplementation) {
        this.carDaoImplementation = carDaoImplementation;
    }

    @Override
    public List<Car> findAll() {
        return carDaoImplementation.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carDaoImplementation.findById(id);
    }

    @Override
    @Transactional
    public void addCar(Car car) {
        carDaoImplementation.addCar(car);
    }

    @Override
    @Transactional
    public void deleteCar(Long id) {
        Car foundCar = carDaoImplementation.findById(id);
        if (foundCar == null) {
            throw new RuntimeException("Car doesn't exist");
        }
        carDaoImplementation.deleteCar(foundCar);
    }
}