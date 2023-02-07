package com.techelevator.controller;


import com.techelevator.dao.RequestDao;
import com.techelevator.dao.ServiceDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Car;
import com.techelevator.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RequestController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private RequestDao requestDao;

//    @RequestMapping(path = "/requestService", method = RequestMethod.POST)
//    public boolean createRequest(@RequestBody)
}
