package com.techelevator.controller;


import com.techelevator.dao.CarDao;
import com.techelevator.dao.RequestDao;
import com.techelevator.dao.ServiceDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RequestController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private RequestDao requestDao;

    @RequestMapping(path = "/requestService", method = RequestMethod.POST)
    public void createRequest(@RequestBody RequestServiceDTO request){
        Car car = new Car(request.getCarId(), request.getMake(), request.getModel(),
                request.getColor(), request.getYear());
        if (car.getCarId() == 0){
            car.setCarId(carDao.create(car.getMake(),car.getModel(),car.getColor(),car.getYear()));
        }
        serviceDao.create(car.getCarId(), request.getOil(), request.getBrakes(), request.getTires(),
                request.getBody(), request.getCarbonAirFilter(), request.getBattery(),
                request.getScheduledMaintenance(), request.getMisc());
    }
}
