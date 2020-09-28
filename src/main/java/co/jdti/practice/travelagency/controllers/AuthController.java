package co.jdti.practice.travelagency.controllers;

import co.jdti.practice.travelagency.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private IUserServices iUserServices;

}
