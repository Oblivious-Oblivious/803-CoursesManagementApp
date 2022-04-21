package app.test;

import jspec.*;
import app.src.entities.*;
import app.test.entities.*;

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new CourseTest(),
            new StudentRegistrationTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
