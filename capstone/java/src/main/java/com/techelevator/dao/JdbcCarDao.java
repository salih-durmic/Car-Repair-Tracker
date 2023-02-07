package com.techelevator.dao;

import com.techelevator.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCarDao implements CarDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        String sql = "select * from cars";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Car car = mapRowToCar(results);
            cars.add(car);
        }
        return cars;
    }

    @Override
    public Car getCarById(int carId) {
        String sql = "select * from cars where car_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, carId);
        if(results.next()){
            return mapRowToCar(results);
        } else {
            return null;
        }
    }

    @Override
    public int create(String make, String model, String color, String year) {
        String sql = "insert into cars (make,model,color,year) values (?,?,?,?) returning car_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class);
        return id;
    }

    private Car mapRowToCar(SqlRowSet results) {
        Car car = new Car();
        car.setCarId(results.getInt("car_id"));
        car.setMake(results.getString("make"));
        car.setModel(results.getString("model"));
        car.setColor(results.getString("color"));
        car.setYear(results.getString("year"));
        return car;
    }
}
