package co.jdti.practice.travelagency.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@CrossOrigin("*")
public class StatusController {

    static final Logger log = LoggerFactory.getLogger(StatusController.class);

    @GetMapping("")
    public String getStatus() {
        log.info("Service status: O.K.");
        return "O.K.";
    }

}
