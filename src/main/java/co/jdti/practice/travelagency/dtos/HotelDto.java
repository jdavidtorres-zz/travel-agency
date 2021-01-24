package co.jdti.practice.travelagency.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class HotelDto {

    private String id;
    private String name;
    private String city;
    private String type;
    private Integer guestsQuantity;
    private Integer roomsQuantity;
    private Integer bathsQuantity;
    private Integer bedsQuantity;
    private Date createdAt;

    public HotelDto(String id, String name, String city, String type, Integer guestsQuantity, Integer roomsQuantity, Integer bathsQuantity, Integer bedsQuantity) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.type = type;
        this.guestsQuantity = guestsQuantity;
        this.roomsQuantity = roomsQuantity;
        this.bathsQuantity = bathsQuantity;
        this.bedsQuantity = bedsQuantity;
    }
}
