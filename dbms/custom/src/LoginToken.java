package dbms.custom.src;

public class LoginToken {
    public String username;
    public String password;

    public LoginToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean equals(LoginToken other) {
        return this.username.equals(other.username)
            && this.password.equals(other.password);
    }
}
