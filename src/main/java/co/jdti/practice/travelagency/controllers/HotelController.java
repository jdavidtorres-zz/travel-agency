package co.jdti.practice.travelagency.controllers;

import co.jdti.practice.travelagency.dtos.HotelDto;
import co.jdti.practice.travelagency.services.IHotelServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel-data")
@CrossOrigin("*")
public class HotelController {

    static final Logger log = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private IHotelServices iHotelServices;

    @GetMapping("/info")
    public ResponseEntity<HotelDto> getHotelData() {
        return new ResponseEntity<>(iHotelServices.getHotelInfo("HOTEL-1"), HttpStatus.OK);
    }
}
