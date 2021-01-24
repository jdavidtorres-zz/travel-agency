package co.jdti.practice.travelagency.implementations;

import co.jdti.practice.travelagency.dtos.HotelDto;
import co.jdti.practice.travelagency.entities.HotelEntity;
import co.jdti.practice.travelagency.repositories.IHotelRepository;
import co.jdti.practice.travelagency.services.IHotelServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServices implements IHotelServices {

    private final IHotelRepository iHotelRepository;

    public HotelServices(IHotelRepository iHotelRepository) {
        this.iHotelRepository = iHotelRepository;
    }

    @Override
    public HotelDto save(HotelDto hotelToSave) {
        HotelEntity newHotel = new HotelEntity(hotelToSave.getName(), hotelToSave.getCity(), hotelToSave.getType(), hotelToSave.getGuestsQuantity(), hotelToSave.getRoomsQuantity(), hotelToSave.getBathsQuantity(), hotelToSave.getBedsQuantity());
        iHotelRepository.save(newHotel);
        return hotelToSave;
    }

    @Override
    public HotelDto getHotelInfo(String id) {
        HotelEntity hotelEntity = iHotelRepository.getOne(id);
        HotelDto hotel = new HotelDto(hotelEntity.getId(), hotelEntity.getName(), hotelEntity.getCity(), hotelEntity.getType(), hotelEntity.getGuestsQuantity(), hotelEntity.getRoomsQuantity(), hotelEntity.getBathsQuantity(), hotelEntity.getBedsQuantity());
        return hotel;
    }

    @Override
    public List<HotelDto> getAll() {
        List<HotelDto> hotelList = new ArrayList<>();
        for (HotelEntity hotelEntity : iHotelRepository.findAll()) {
            hotelList.add(new HotelDto(hotelEntity.getId(), hotelEntity.getName(), hotelEntity.getCity(), hotelEntity.getType(), hotelEntity.getGuestsQuantity(), hotelEntity.getRoomsQuantity(), hotelEntity.getBathsQuantity(), hotelEntity.getBedsQuantity()));
        }
        return hotelList;
    }
}
