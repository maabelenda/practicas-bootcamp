package Entity;

import Exceptions.BadPasswordException;
import Utils.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private Pattern pattern;

    private String password;

    public Password(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    private boolean validatePassword(String password) {
        Matcher m = this.pattern.matcher(password);
        return m.matches();
    }

    public void setPassword(String password) throws BadPasswordException {
        if(!validatePassword(password)) {
            throw new BadPasswordException(ErrorMessage.BAD_PASSWORD.getMessage(), ErrorMessage.BAD_PASSWORD.getCode());
        }
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

}
