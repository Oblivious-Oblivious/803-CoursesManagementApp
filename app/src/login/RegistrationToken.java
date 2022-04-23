package app.src.login;

import java.io.Serializable;

public class RegistrationToken implements Serializable {
    public String username;
    public String password;

    public RegistrationToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String get_username() {
        return this.username;
    }

    public String get_password() {
        return this.password;
    }

    public boolean equals(RegistrationToken other) {
        return this.username.equals(other.username)
            && this.password.equals(other.password);
    }
}
