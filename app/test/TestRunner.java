package app.test;

import jspec.*;

import app.src.datamodels.*;
import app.test.datamodels.*;

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new ListOfCoursesTest(),
            new CourseTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
