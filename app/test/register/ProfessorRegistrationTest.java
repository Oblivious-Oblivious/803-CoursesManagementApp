package app.test.register;

import app.src.register.ProfessorRegistration;
import app.src.register.RegistrationToken;
import app.src.entities.*;

import dbms.CustomGatewayImplementation;

import jspec.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProfessorRegistrationTest extends SpecModule {
    private ProfessorRegistration reg = null;

    private String sha512hash(String password) {
        try {
            MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            byte md[] = sha512.digest(password.getBytes());
            String hash = new BigInteger(1, md).toString(16);

            while(hash.length() < 32)
                hash += "0";

            return hash;
        }
        catch(NoSuchAlgorithmException e) {
            return "";
        }
    }

    public void spec_code() {
        describe("Professor Registration", () -> {
            it("creates a new registration object", () -> {
                String password = "123abc";
                this.reg = new ProfessorRegistration(
                    new RegistrationToken("Oblivious", password),
                    new CustomGatewayImplementation("Accounts")
                );

                assert_that(this.reg).isnot(null);
            });

            it("checks if the password has at least 4 words with size at least 10", () -> {
                String password = "one two three four";
                this.reg = new ProfessorRegistration(
                    new RegistrationToken("Oblivious", password),
                    new CustomGatewayImplementation("Accounts")
                );

                assert_that(this.reg.password_is_safe()).is(true);
            });

            it("fails if password has less that 4 words", () -> {
                String password = "word1 word2 word3";
                this.reg = new ProfessorRegistration(
                    new RegistrationToken("Oblivious", password),
                    new CustomGatewayImplementation("Accounts")
                );

                assert_that(this.reg.password_is_safe()).is(false);
            });

            it("fails if password has less that 10 characters", () -> {
                String password = "a b c d e";
                this.reg = new ProfessorRegistration(
                    new RegistrationToken("Oblivious", password),
                    new CustomGatewayImplementation("Accounts")
                );

                assert_that(this.reg.password_is_safe()).is(false);
            });

            it("fails if username already exists", () -> {
                String username = "Oblivious";
                String password = "one two three four";
                
                Schema reg_token1 = new Schema("reg1", new RegistrationToken("Oblivious", "asg sagwqg qg gqqw"));
                Schema reg_token2 = new Schema("reg2", new RegistrationToken("Another", "asg sagwqg qg gqqw"));
                Schema reg_token3 = new Schema("reg3", new RegistrationToken("Test", "asg sagwqg qg gqqw"));
                
                RegistrationToken current = new RegistrationToken(username, password);

                DBMSGateway accounts_db = new CustomGatewayImplementation("Accounts");
                accounts_db.save(reg_token1);
                accounts_db.save(reg_token2);
                accounts_db.save(reg_token3);

                this.reg = new ProfessorRegistration(current, accounts_db);
                assert_that(this.reg.username_is_safe()).is(false);
            });

            it("succeeds if username is unique", () -> {
                String username = "Oblivious";
                String password = "one two three four";

                DBMSGateway accounts_db = new CustomGatewayImplementation("Accounts");
                RegistrationToken current = new RegistrationToken(username, password);
                this.reg = new ProfessorRegistration(current, accounts_db);

                assert_that(this.reg.username_is_safe()).is(true);
            });

            it("saves a registration token in the db as a login token", () -> {
                String username = "Oblivious";
                String password = "one two three four";
                DBMSGateway accounts_db = new CustomGatewayImplementation("Accounts");
                RegistrationToken current = new RegistrationToken(username, password);
                this.reg = new ProfessorRegistration(current, accounts_db);

                assert_that(this.reg.save_to_db_as_login_token()).is(true);
            });

            it("tries to save a token twice but only succeeds the first time", () -> {
                String username = "Oblivious";
                String password = "one two three four";
                DBMSGateway accounts_db = new CustomGatewayImplementation("Accounts");
                RegistrationToken current = new RegistrationToken(username, password);
                this.reg = new ProfessorRegistration(current, accounts_db);

                assert_that(this.reg.save_to_db_as_login_token()).is(true);
                assert_that(this.reg.save_to_db_as_login_token()).is(false);
                assert_that(this.reg.save_to_db_as_login_token()).is(false);
            });

            it("hashes password using SHA", () -> {
                String password = "this is a random password";
                this.reg = new ProfessorRegistration(
                    new RegistrationToken("Oblivious", password),
                    new CustomGatewayImplementation("Accounts")
                );
                String hashed = this.reg.hash_password();

                assert_that(hashed.equals(sha512hash(password))).is(true);
            });
        });
    }
}
