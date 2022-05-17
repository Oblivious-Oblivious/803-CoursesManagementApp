package app.src.login;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import app.src.boundaries.LoginBoundary;
import app.src.entities.Identifiable;
import app.src.entities.PersistenceGateway;
import app.src.entities.RegistrationToken;

public class ProfessorLogin implements LoginBoundary {
    private RegistrationToken token = null;
    private PersistenceGateway accounts_db = null;

    private String hash_password() {
        try {
            MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            byte md[] = sha512.digest(this.token.password.getBytes());
            String hash = new BigInteger(1, md).toString(16);

            while(hash.length() < 32)
                hash += "0";

            return hash;
        }
        catch(NoSuchAlgorithmException e) {
            return "";
        }
    }

    public ProfessorLogin(RegistrationToken token, PersistenceGateway accounts_db) {
        this.token = token;
        this.accounts_db = accounts_db;
    }

    @Override
    public boolean login() {
        this.token.password = hash_password();
        for(Identifiable acc : this.accounts_db.get_all_items())
            if(((RegistrationToken)acc).equals(this.token))
                return true;

        return false;
    }
}
