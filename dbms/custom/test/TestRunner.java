package dbms.custom.test;

import jspec.*;

import dbms.custom.src.*;

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new CustomDBTest(),
            new LoginTokenTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
