package co.jdti.practice.travelagency.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@CrossOrigin("*")
public class StatusController {

    @GetMapping("")
    public String getStatus() {
        return "O.K.";
    }

}
