package co.jdti.practice.travelagency.implementations;

import co.jdti.practice.travelagency.entities.UserEntity;
import co.jdti.practice.travelagency.repositories.IUserRepository;
import co.jdti.practice.travelagency.services.IUserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class UserServices implements IUserServices, UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserServices.class);

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    @Override
    public String createUserAndToken() {
        return null;
    }

    @Override
    public UserDto getUser(String username) {
        UserEntity user = iUserRepository.findByUsername(username);
        if (user != null) {
            return new UserDto(user.getUsername(), user.getPassword());
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userLogged;
        userLogged = getUser(username);
        if (userLogged == null) {
            logger.error("Error en el Login: no existe el usuario en el sistema!");
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
        return new User(userLogged.getUsername(), userLogged.getPassword(), true, true, true, true, new ArrayList<>());
    }
}
