package persistence;

import jspec.*;
import persistence.custom.test.CustomDBTest;
import persistence.dynamiclist.test.DynamicListTest;
import persistence.sqlite.test.SqliteApiTest;

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new CustomDBTest(),
            new DynamicListTest(),
            new SqliteApiTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
