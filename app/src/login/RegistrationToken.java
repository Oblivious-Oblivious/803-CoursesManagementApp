package app.src.login;

import java.io.Serializable;
import app.src.entities.PersistenceGateway;
import persistence.CustomGatewayImplementation;

public class RegistrationToken implements Serializable {
    public String id;
    public String username;
    public String password;

    /* TODO inject this */
    private transient PersistenceGateway courses_db = null;

    public RegistrationToken(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.courses_db = new CustomGatewayImplementation(this.username + "_courses");
    }

    public PersistenceGateway get_courses_db() {
        if(this.courses_db == null)
            this.courses_db = new CustomGatewayImplementation(this.username + "_courses");
        return this.courses_db;
    }

    public boolean equals(RegistrationToken other) {
        return this.username.equals(other.username)
            && this.password.equals(other.password);
    }
}
