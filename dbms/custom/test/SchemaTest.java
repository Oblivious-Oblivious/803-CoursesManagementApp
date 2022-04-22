package dbms.custom.test;

import dbms.custom.src.Schema;
import jspec.*;

public class SchemaTest extends SpecModule {
    public void spec_code() {
        describe("Schema object", () -> {
            it("creates a random schema object", () -> {
                String id = "test1";
                String item = "an item";

                Schema s = new Schema<String>(id, item);
                Schema other = new Schema<String>("test1", "an item");
                assert_that(s.equals(other)).equals_to(true);
            });
        });
    }
}
