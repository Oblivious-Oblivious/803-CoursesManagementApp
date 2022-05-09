package app.src.login;
// TODO Inlcude jar files in gitignore
import java.util.ArrayList;

import java.io.Serializable;
import app.src.entities.Course;
import app.src.entities.PersistenceGateway;
import persistence.CustomGatewayImplementation;

public class RegistrationToken implements Serializable {
    public String id;
    public String username;
    public String password;

    /* TODO inject this */
    public PersistenceGateway courses_db = new CustomGatewayImplementation("Accounts");

    public RegistrationToken(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    }

    public boolean equals(RegistrationToken other) {
        return this.username.equals(other.username)
            && this.password.equals(other.password);
    }
}
