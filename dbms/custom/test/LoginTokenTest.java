package dbms.custom.test;

import jspec.*;

import dbms.custom.src.LoginToken;

public class LoginTokenTest extends SpecModule {
    public void spec_code() {
        describe("LoginToken", () -> {
            it("creates a login token with initial parameters", () -> {
                LoginToken token = new LoginToken("oblivious", "123456");
                assert_that(token).isnot(null);
            });

            it("checks for equality for 2 login tokens", () -> {
                LoginToken t1 = new LoginToken("batman", "1234");
                LoginToken t2 = new LoginToken("batman", "1234");

                assert_that(t1.equals(t2)).is(true);
            });

            it("checks for inequality for 2 login token", () -> {
                LoginToken t1 = new LoginToken("batman", "1234");
                LoginToken t2 = new LoginToken("batman", "8521");

                assert_that(t1.equals(t2)).is(false);
            });
        });
    }
}
