package com.techelevator.dao;

import com.techelevator.model.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcServiceDao implements ServiceDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcServiceDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Service> findAll() {
        List<Service> services = new ArrayList<>();
        String sql = "select * from service";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Service service = mapRowToService(results);
            services.add(service);
        }
        return services;
    }

    @Override
    public Service getServiceById(int serviceId) {
        String sql = "select * from service where service_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, serviceId);
        if (results.next()){
            return mapRowToService(results);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(String oil, String brakes, String tires, String body, String carbonAirFilter, String battery, String scheduledMaintenance, String misc) {
        String sql = "insert into service(oil,brakes,tires,body,carbon_air_filter,battery,scheduled_maintenance,misc) values (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, oil, brakes, tires, carbonAirFilter, battery, scheduledMaintenance, misc) == 1;
    }

    private Service mapRowToService(SqlRowSet results){
        Service service = new Service();
        service.setServiceId(results.getInt("service_id"));
        service.setOil(results.getString("oil"));
        service.setBrakes(results.getString("brakes"));
        service.setTires(results.getString("tires"));
        service.setBody(results.getString("body"));
        service.setCarbonAirFilter(results.getString("carbon_air_filter"));
        service.setBattery(results.getString("battery"));
        service.setScheduledMaintenance(results.getString("scheduled_maintenance"));
        service.setMisc(results.getString("misc"));
        return service;
    }
}
