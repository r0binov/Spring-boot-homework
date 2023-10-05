package com.example.CarStore.dao;

import com.example.CarStore.model.Car;

import java.util.List;

public interface CarDAO {
    List<Car> findAll();

    Car findById(Long id);

    void addCar(Car car);

    void deleteCar(Car car);
}