package com.example.CarStore.api;

import com.example.CarStore.model.Car;
import com.example.CarStore.service.CarServiceImplementation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRESTController {
    private final CarServiceImplementation carServiceImplementation;

    public CarRESTController(CarServiceImplementation carServiceImplementation) {
        this.carServiceImplementation = carServiceImplementation;
    }

    @GetMapping("/cars")
    public List<Car> findAll() {
        return carServiceImplementation.findAll();
    }

    @GetMapping("/cars/{carId}")
    public Car findCarById(@PathVariable("carId") Long id) {
        return carServiceImplementation.findById(id);
    }

    @PostMapping("/addCar")
    public String addCar(@RequestBody Car car) {
        carServiceImplementation.addCar(car);

        return "Added car" + car;
    }

    @PutMapping("/updateCar/{carId}")
    public String updateCarById(@PathVariable("carId") Long id, @RequestBody Car updatedCar) {
        Car existingCar = carServiceImplementation.findById(id);

        if (existingCar == null) {
            throw new RuntimeException("Car with ID " + id + " not found");
        }

        existingCar.setManufacturer(updatedCar.getManufacturer());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setYear(updatedCar.getYear());
        existingCar.setMileage(updatedCar.getMileage());

        carServiceImplementation.addCar(existingCar);

        return "Updated car with ID " + id + "to now have the following data: " + updatedCar;
    }

    @DeleteMapping("/deleteCar/{carId}")
    public String deleteCar(@PathVariable("carId") Long id) {

        carServiceImplementation.deleteCar(id);

        return "Car with id " + id + " was deleted";
    }
}

