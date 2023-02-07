package com.techelevator.dao;

import com.techelevator.model.Car;

import java.util.List;

public interface CarDao {

    List<Car> findAll();

    Car getCarById(int carId);

    int create(int userId, String make, String model, String color, String year);
}
