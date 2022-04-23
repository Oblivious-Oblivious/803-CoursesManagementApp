package app.src.login;

import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

public class ProfessorLogin {
    private RegistrationToken token = null;
    private DBMSGateway accounts_db = null;

    public ProfessorLogin(RegistrationToken token, DBMSGateway accounts_db) {
        this.token = token;
        this.accounts_db = accounts_db;
    }

    public boolean login() {
        /* TODO Change method of searching to search by name or id */
        for(Schema acc : this.accounts_db.get_all_items())
            if(((RegistrationToken)acc.value()).equals(this.token))
                return true;

        return false;
    }
}
