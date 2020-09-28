package co.jdti.practice.travelagency.config;

import co.jdti.practice.travelagency.implementations.UserDto;
import co.jdti.practice.travelagency.utils.Constants;
import co.jdti.practice.travelagency.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @SneakyThrows(IOException.class)
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authenticationToken = null;
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username != null && password != null) {
            username = username.trim();
            try {
                authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
                return authenticationManager.authenticate(authenticationToken);
            } catch (Exception ex) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, Constants.UNSUCCESSFUL_AUTHENTICATION);
                logger.warn(ex.getMessage());
                return null;
            }
        } else {
            UserDto userDto;
            try {
                userDto = new ObjectMapper().readValue(request.getInputStream(), UserDto.class);
                username = userDto.getUsername();
                password = userDto.getPassword();
                username = username.trim();
                authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
                return authenticationManager.authenticate(authenticationToken);
            } catch (Exception ex) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, Constants.UNSUCCESSFUL_AUTHENTICATION);
                logger.warn(ex.getMessage());
                return null;
            }
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = ((User) authResult.getPrincipal()).getUsername();
        String token = Utils.generateToken(username, new Date());
        response.addHeader(Constants.HEADER, Constants.PREFIX + token);
        Map<String, Object> body = new HashMap<>();
        body.put("username", username);
        body.put("tokenSession", token);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "Error de autenticaci\u00f3n: username o password incorrecto!");
        logger.error(Constants.UNSUCCESSFUL_AUTHENTICATION);
        logger.error(failed.getMessage());
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType("application/json");
    }
}
