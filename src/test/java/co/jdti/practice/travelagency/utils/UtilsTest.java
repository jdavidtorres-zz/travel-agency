package co.jdti.practice.travelagency.utils;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    void getUsernameFromToken() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format.parse("25/09/2020");
        String token = Constants.PREFIX + Utils.generateToken("Test12345", date);
        assertEquals("Test12345", Utils.getUsernameFromToken(token));
    }
}
