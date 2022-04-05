package app.test;

import jspec.*;

import app.src.hello.*;
// import app.src.login.*;
/* */
/* */
/* */

import app.test.hello.*;
// import app.test.login.*;
/* */
/* */
/* */

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new HelloTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
