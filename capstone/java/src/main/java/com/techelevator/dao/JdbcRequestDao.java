package com.techelevator.dao;

import com.techelevator.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRequestDao implements RequestDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRequestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Request> findAll() {
        List<Request> requests = new ArrayList<>();
        String sql = "select * from requests";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Request request = mapRowToRequest(results);
            requests.add(request);
        }
        return requests;
    }

    @Override
    public Request getRequestById(int requestId) {
        String sql = "select * from requests where request_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, requestId);
        if (results.next()){
            return mapRowToRequest(results);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(String dateReported, String estimatedCompletionDate, String status, BigDecimal estimatedCost, BigDecimal laborCost, boolean paid) {
        String sql = "insert into requests (date_reported,estimated_completion_date,status,estimated_cost,labor_cost,paid) values (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, dateReported, estimatedCompletionDate, status, estimatedCost, laborCost, paid) == 1;
    }

    private Request mapRowToRequest(SqlRowSet results){
        Request request = new Request();
        request.setRequestId(results.getInt("request_id"));
        request.setDateReported(results.getString("date_reported"));
        request.setEstimatedCompletionDate(results.getString("estimated_completion_date"));
        request.setStatus(results.getString("status"));
        request.setEstimatedCost(results.getBigDecimal("estimated_cost"));
        request.setLaborCost(results.getBigDecimal("labor_cost"));
        request.setPaid(results.getBoolean("paid"));
        return request;
    }
}