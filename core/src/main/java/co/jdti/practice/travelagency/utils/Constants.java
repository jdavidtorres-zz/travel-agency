package co.jdti.practice.travelagency.utils;

public class Constants {

    private Constants() {
        // Empty constructor
    }

    // Token
    public static final String HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final String SECRET = "_SECRET_SECRET_SECRET_";
    public static final int TIME_EXPIRATION_PLUS = 500000;

    // Path
    public static final String REGISTER_PATH = "/auth/";

    // Message
    public static final String UNSUCCESSFUL_AUTHENTICATION = "Autenticacion incorrecta";

}
