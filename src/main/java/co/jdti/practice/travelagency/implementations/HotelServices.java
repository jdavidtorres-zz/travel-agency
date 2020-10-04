package co.jdti.practice.travelagency.implementations;

import co.jdti.practice.travelagency.dtos.HotelDto;
import co.jdti.practice.travelagency.entities.HotelEntity;
import co.jdti.practice.travelagency.repositories.IHotelRepository;
import co.jdti.practice.travelagency.services.IHotelServices;
import org.springframework.stereotype.Service;

@Service
public class HotelServices implements IHotelServices {

    private final IHotelRepository iHotelRepository;

    public HotelServices(IHotelRepository iHotelRepository) {
        this.iHotelRepository = iHotelRepository;
    }

    @Override
    public HotelDto save(HotelDto hotelToSave) {
        HotelEntity newHotel = new HotelEntity(hotelToSave.getName(), hotelToSave.getCity(), hotelToSave.getType(), hotelToSave.getGuestsQuantity(), hotelToSave.getRoomsQuantity(), hotelToSave.getBathsQuantity(), hotelToSave.getBedsQuantity());
        newHotel.setId("HOTEL-1");
        iHotelRepository.save(newHotel);
        return hotelToSave;
    }

    @Override
    public HotelDto getHotelInfo(String id) {
        iHotelRepository.getOne(id);
        return null;
    }
}
