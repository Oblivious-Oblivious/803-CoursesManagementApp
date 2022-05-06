package dbms.dynamiclist.test;

import jspec.*;
import app.test.entities.SchemaTest;
import dbms.dynamiclist.src.*;

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new DynamicListTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
