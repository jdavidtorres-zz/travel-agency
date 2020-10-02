package co.jdti.practice.travelagency.utils;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    void getUsernameFromToken() throws Exception {
        String token = Constants.PREFIX + Utils.generateToken("Test12345", new Date());
        assertEquals("Test12345", Utils.getUsernameFromToken(token));
    }
}
