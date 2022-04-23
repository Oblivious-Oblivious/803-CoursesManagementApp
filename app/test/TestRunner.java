package app.test;

import jspec.*;

import app.test.entities.*;
import app.test.login.*;

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new CourseTest(),
            new SchemaTest(),
            new StudentRegistrationTest(),
            new ProfessorLoginTest(),
            new ProfessorRegistrationTest(),
            new RegistrationTokenTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
