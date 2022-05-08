package persistence.custom.test;

import jspec.*;
import persistence.custom.src.CustomDB;

import java.util.ArrayList;

import app.src.entities.Schema;

public class CustomDBTest extends SpecModule {
    public void spec_code() {
        describe("Basic CustomDB function", () -> {
            it("creates a DB", () -> {
                CustomDB db = new CustomDB("testdb_1");
                assert_that(db).isnot(null);
            });

            it("adds a String to the DB", () -> {
                CustomDB db = new CustomDB("testdb_2");
                String id = "entry1";
                String str = "Lesson";
                Schema item = new Schema<String>(id, str);

                db.save(item);
                assert_that(db.get_by_id(id).equals(item)).is(true);
            });
            
            it("adds 3 Integers to the DB", () -> {
                CustomDB db = new CustomDB("testdb_3");
                db.save(new Schema<Integer>("3rd",39));
                db.save(new Schema<Integer>("1st",1));
                db.save(new Schema<Integer>("2nd",2));

                int first = (Integer)db.get_by_id("1st").value();
                int third = (Integer)db.get_by_id("3rd").value();
                int second = (Integer)db.get_by_id("2nd").value();
                assert_that(first+second+third).equals_to(42);
            });
            
            it("gets all items", () -> {
                CustomDB db = new CustomDB("testdb_4");
                String id1 = "entry1";
                String id2 = "entry2";
                String id3 = "entry3";
                String item1 = "Lesson";
                String item2 = "Less3on";
                String item3 = "Lesson4";
                Schema s1 = new Schema<String>(id1, item1);
                Schema s2 = new Schema<String>(id2, item2);
                Schema s3 = new Schema<String>(id3, item3);
                db.save(s1);
                db.save(s2);
                db.save(s3);

                ArrayList<Schema> items = db.get_all_items();
                assert_that(items.get(0).equals(s1)).is(true);
                assert_that(items.get(2).equals(s3)).is(true);
                assert_that(items.get(1).equals(s2)).is(true);
            });

            it("updates the new item", () -> {
                CustomDB db = new CustomDB("testdb_5");
                String id1 = "Lecture1";
                String item1 = "Digital Design I";

                db.save(new Schema<String>(id1, item1));
                db.update(id1, new Schema(id1, "Operating Systems"));

                assert_that(db.get_by_id(id1).value()).equals_to("Operating Systems");
            });

            it("deletes an item by id", () -> {
                CustomDB db = new CustomDB("testdb_6");
                String id1 = "Lecture1";
                String item1 = "Digital Design I";
                String id2 = "Lecture2";
                String item2 = "Digital Design II";

                db.save(new Schema<String>(id1, item1));
                db.save(new Schema<String>(id2, item2));
                db.delete(id1);

                assert_that(db.get_all_items().size()).is(1);
                assert_that(db.get_by_id(id2).value()).equals_to("Digital Design II");
            });
        });
    }
}
