package co.jdti.practice.travelagency.services;

import co.jdti.practice.travelagency.dtos.HotelDto;

public interface IHotelServices {
    HotelDto save(HotelDto hotelToSave);

    HotelDto getHotelInfo(String id);
}
