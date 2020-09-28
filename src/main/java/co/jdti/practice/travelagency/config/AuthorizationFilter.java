package co.jdti.practice.travelagency.config;

import co.jdti.practice.travelagency.utils.Constants;
import co.jdti.practice.travelagency.utils.Utils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String headerAuthToken = request.getHeader(Constants.HEADER);
        if (headerAuthToken == null || headerAuthToken.startsWith(Constants.PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(headerAuthToken);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String sessionToken) {
        String userId = Utils.getUsernameFromToken(sessionToken);
        if (userId != null) {
            return new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
        }
        return null;
    }
}
