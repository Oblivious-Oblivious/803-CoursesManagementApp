package app.test.login;

import app.src.login.ProfessorLogin;
import app.src.login.RegistrationToken;
import app.src.entities.Schema;

import persistence.CustomGatewayImplementation;

import jspec.*;

public class ProfessorLoginTest extends SpecModule {
    public void spec_code() {
        describe("professor login object", () -> {
            it("creates a new login object with a registration token and an accounts db", () -> {
                ProfessorLogin log = new ProfessorLogin(
                    new RegistrationToken("Oblivious", "one two three four"),
                    new CustomGatewayImplementation("Accounts")
                );

                assert_that(log).isnot(null);
            });

            it("sucessfully logins with an existing registration token", () -> {
                CustomGatewayImplementation accounts_db = new CustomGatewayImplementation("Accounts");
                accounts_db.save(new Schema("acc1", new RegistrationToken("Oblivious", "one two three four")));
                accounts_db.save(new Schema("acc2", new RegistrationToken("Second", "one two three four")));
                accounts_db.save(new Schema("acc3", new RegistrationToken("Third", "one two three four")));

                ProfessorLogin log = new ProfessorLogin(
                    new RegistrationToken("Oblivious", "one two three four"),
                    accounts_db
                );

                assert_that(log.login()).is(true);
            });

            it("fails to login with a non existing registration token", () -> {
                ProfessorLogin log = new ProfessorLogin(
                    new RegistrationToken("Oblivious", "one two three four"),
                    new CustomGatewayImplementation("Accounts")
                );

                assert_that(log.login()).is(false);
            });
        });
    }
}
