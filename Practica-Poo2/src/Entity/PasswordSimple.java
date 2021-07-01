package Entity;

import Entity.Password;

public class PasswordSimple extends Password {

    public static String regex = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,10}$";

    public PasswordSimple() {
        super(regex);
    }
}
