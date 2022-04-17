package dbms.custom.test;

import jspec.*;
import java.util.HashMap;

import dbms.custom.src.*;

public class CustomDBTest extends SpecModule {
    private CustomDB db = null;

    public void spec_code() {
        describe("Basic CustomDB function", () -> {
            it("Creates a String DB", () -> {
                this.db = new CustomDB<String>("testdb_1");
                assert_that(this.db).isnot(null);
            });

            it("Creates an Integer DB", () -> {
                this.db = new CustomDB<Integer>("testdb_2");
                assert_that(this.db).isnot(null);
            });

            it("Adds a String to the DB", () -> {
                this.db = new CustomDB<String>("testdb_3");
                String id = "entry1";
                String item = "Lesson";
                this.db.add(id, item);
                assert_that(this.db.get(id)).equals_to("Lesson");
            });
            
            it("Adds 3 Integers to the DB", () -> {
                this.db = new CustomDB<Integer>("testdb_4");
                int x = 1;
                int y = 2;
                int z = 45;
                this.db.add("1st",x);
                this.db.add("2nd",y);
                this.db.add("3rd",z);

                int first = (Integer)this.db.get("1st");
                int second = (Integer)this.db.get("2nd");
                int third = (Integer)this.db.get("3rd");
                assert_that(first+second+third).equals_to(48);
            });
            
            it("Gets all items", () -> {
                this.db = new CustomDB<String>("testdb_5");
                String id1 = "entry1";
                String id2 = "entry2";
                String id3 = "entry3";
                String item1 = "Lesson";
                String item2 = "Less3on";
                String item3 = "Lesson4";
                this.db.add(id1, item1);
                this.db.add(id2, item2);
                this.db.add(id3, item3);

                HashMap<String, String> items = this.db.get_all_items();
                assert_that(items.get(id1)).equals_to(item1);
                assert_that(items.get(id2)).equals_to(item2);
                assert_that(items.get(id3)).equals_to(item3);
            });

            it("Updates the new item", () -> {
                this.db = new CustomDB<String>("testdb_6");
                String id1 = "Lecture1";
                String item1 = "Digital Design I";
                this.db.add(id1, item1);
                this.db.update(id1,"Operating Systems");

                assert_that(this.db.get(id1)).equals_to("Operating Systems");
            });
            
            it("authenticates login data", () -> {
                this.db = new CustomDB<LoginToken>("testdb_7");
                this.db.add("rid1", new LoginToken("oblivious", "123456"));
                this.db.add("rid2", new LoginToken("batman", "3276"));
                this.db.add("rid3", new LoginToken("xontros", "5"));

                boolean test1 = this.db.login("oblivious", "123456");
                boolean test2 = this.db.login("fasfasif", "123456");
                boolean test3 = this.db.login("oblivious", "48654");
                boolean test4 = this.db.login("adgasg", "1eqegq");

                assert_that(test1).is(true);
                assert_that(test2).is(false);
                assert_that(test3).is(false);
                assert_that(test4).is(false);
            });
        });
    }
}
