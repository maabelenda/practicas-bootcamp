package Entity;

import Entity.Password;

public class PasswordIntermedia extends Password {

    public static String regex = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";

    public PasswordIntermedia() {
        super(regex);
    }

}
