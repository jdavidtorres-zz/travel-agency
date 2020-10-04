package co.jdti.practice.travelagency;

import co.jdti.practice.travelagency.dtos.HotelDto;
import co.jdti.practice.travelagency.services.IHotelServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelAgencyApplication implements CommandLineRunner {

    static final Logger log = LoggerFactory.getLogger(TravelAgencyApplication.class);

    @Autowired
    private IHotelServices iHotelServices;

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        HotelDto newHotel = new HotelDto("Cabaña con estilo y lujo", "Guatape", "Cabaña", 6, 2, 2, 3);
        iHotelServices.save(newHotel);
        HotelDto newHotel2 = new HotelDto("Hotel Decameron Baru", "Cartagena", "Hotel", 6, 2, 2, 3);
        iHotelServices.save(newHotel2);
        log.info("Primera inserción - TEST");
    }
}
