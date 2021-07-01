package Entity;

import Entity.Password;

public class PasswordFuerte extends Password {

    public static String regex = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";

    public PasswordFuerte() {
        super(regex);
    }
}
