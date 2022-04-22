package app.src.register;

public class RegistrationToken {
    public String username;
    public String password;

    public RegistrationToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean equals(RegistrationToken other) {
        return this.username.equals(other.username)
            && this.password.equals(other.password);
    }
}
