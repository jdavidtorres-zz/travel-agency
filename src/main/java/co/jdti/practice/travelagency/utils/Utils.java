package co.jdti.practice.travelagency.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Utils {

    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    public static String getUsernameFromToken(String dirtyToken) {
        String username = null;
        try {
            username = Jwts.parser().setSigningKey(Constants.SECRET).parseClaimsJws(getCleanToken(dirtyToken)).getBody().getSubject();
            log.info("The token is OK.");
            return username;
        } catch (ExpiredJwtException e) {
            username = null;
            log.error("Token ha expirado");
        } catch (UnsupportedJwtException e) {
            username = null;
            log.error("Error en el Token");
        } catch (MalformedJwtException e) {
            username = null;
            log.error("Token mal construido");
        } catch (SignatureException e) {
            username = null;
            log.error("Firma del Token erronea");
        } catch (IllegalArgumentException e) {
            username = null;
            log.error("Error en el Token");
            log.warn(e.getMessage());
        }
        return null;
    }

    public static String generateToken(String username, Date sessionDate) {
        try {
            Instant expireInstant = sessionDate.toInstant().plusSeconds(Constants.TIME_EXPIRATION_PLUS);
            Date expireDate = Date.from(expireInstant);
            return Jwts.builder().setId(UUID.randomUUID().toString()).setSubject(username).setIssuedAt(new Date()).setExpiration(expireDate).signWith(SignatureAlgorithm.HS256, Constants.SECRET).compact();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    private static String getCleanToken(String dirtyToken) {
        if (dirtyToken.contains(Constants.PREFIX)) {
            return dirtyToken.replace(Constants.PREFIX, "");
        } else {
            return dirtyToken;
        }
    }
}
