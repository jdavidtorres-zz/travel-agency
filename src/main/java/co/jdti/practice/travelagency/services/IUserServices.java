package co.jdti.practice.travelagency.services;

import co.jdti.practice.travelagency.dtos.UserDto;

public interface IUserServices {

    String createUserAndToken();
    UserDto getUser(String username);

}
