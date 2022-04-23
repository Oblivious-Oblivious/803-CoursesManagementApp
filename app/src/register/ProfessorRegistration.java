package app.src.register;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import app.src.entities.*;

public class ProfessorRegistration {
    private DBMSGateway accounts_db;
    private String username;
    private String password;

    public ProfessorRegistration(RegistrationToken reg, DBMSGateway accounts_db) {
        this.accounts_db = accounts_db;
        this.username = reg.get_username();
        this.password = reg.get_password();
    }

    public boolean username_is_safe() {
        for(Schema item : this.accounts_db.get_all_items()) {
            RegistrationToken token = (RegistrationToken)item.value();
            if(token.get_username().equals(username))
                return false;
        }

        return true;
    }

    public boolean password_is_safe() {
        if(this.password.length() > 0 && this.password.length() < 10)
            return false;
        return this.password.split(" ").length >= 4;
    }

    public boolean bounds_check() {
        return username_is_safe() && password_is_safe();
    }

    public String hash_password() {
        try {
            MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            byte md[] = sha512.digest(this.password.getBytes());
            String hash = new BigInteger(1, md).toString(16);

            while(hash.length() < 32)
                hash += "0";

            return hash;
        }
        catch(NoSuchAlgorithmException e) {
            return "";
        }
    }

    public boolean save_to_db_as_login_token() {
        if(!bounds_check())
            return false;

        RegistrationToken token = new RegistrationToken(
            this.username,
            hash_password()
        );

        Schema<RegistrationToken> item = new Schema<RegistrationToken>(this.username, token);
        this.accounts_db.save(item);

        return true;
    }
}
