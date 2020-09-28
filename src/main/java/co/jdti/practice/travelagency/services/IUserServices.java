package co.jdti.practice.travelagency.services;

import co.jdti.practice.travelagency.implementations.UserDto;

public interface IUserServices {

    String createUserAndToken();
    UserDto getUser(String username);

}
