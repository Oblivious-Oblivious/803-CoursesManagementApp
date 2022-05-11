package app.src.login;

import app.src.entities.Identifiable;
import app.src.entities.PersistenceGateway;
import app.src.entities.RegistrationToken;

public class ProfessorLogin {
    private RegistrationToken token = null;
    private PersistenceGateway accounts_db = null;

    public ProfessorLogin(RegistrationToken token, PersistenceGateway accounts_db) {
        this.token = token;
        this.accounts_db = accounts_db;
    }

    public boolean login() {
        /* TODO Change method of searching to search by name or id */
        for(Identifiable acc : this.accounts_db.get_all_items())
            if(((RegistrationToken)acc).equals(this.token))
                return true;

        return false;
    }
}
