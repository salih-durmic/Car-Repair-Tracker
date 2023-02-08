package com.techelevator.dao;

import com.techelevator.model.Request;

import java.math.BigDecimal;
import java.util.List;

public interface RequestDao {

    List<Request> findAll();

    Request getRequestById(int requestId);

    boolean create(String dateReported, String estimatedCompletionDate, String status, BigDecimal estimatedCost, BigDecimal laborCost, boolean paid);

    List <Request> getRequestByServiceId(int serviceId);
}
