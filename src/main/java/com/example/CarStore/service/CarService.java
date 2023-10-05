package com.example.CarStore.service;

import com.example.CarStore.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car findById(Long id);

    void addCar(Car car);

    void deleteCar(Long id);
}
