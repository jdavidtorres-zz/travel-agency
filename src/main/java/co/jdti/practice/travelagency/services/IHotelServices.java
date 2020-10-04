package co.jdti.practice.travelagency.services;

import co.jdti.practice.travelagency.dtos.HotelDto;

import java.util.List;

public interface IHotelServices {
    HotelDto save(HotelDto hotelToSave);

    HotelDto getHotelInfo(String id);

    List<HotelDto> getAll();
}
