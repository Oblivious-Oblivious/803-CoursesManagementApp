package test;

import jspec.*;

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new HelloTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
