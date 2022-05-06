package dbms.dynamiclist.test;

import jspec.*;
import java.util.ArrayList;

import app.src.entities.Schema;
import dbms.dynamiclist.src.DynamicList;

public class DynamicListTest extends SpecModule {
    private DynamicList list = null;

    public void spec_code() {
        describe("DynamicList (ArrayList wrapper)", () -> {
            before_each(() -> {
                this.list = new DynamicList();
            });

            it("creates a list", () -> {
                assert_that(list).isnot(null);
            });

            it("adds a String to the list", () -> {
                String id = "entry1";
                String str = "Lesson";
                Schema item = new Schema<String>(id, str);

                this.list.save(item);
                assert_that(this.list.get_by_id(id)).equals_to(item);
            });

            it("gets all items", () -> {
                String id1 = "entry1";
                String id2 = "entry2";
                String id3 = "entry3";
                String item1 = "Lesson";
                String item2 = "Less3on";
                String item3 = "Lesson4";
                Schema s1 = new Schema<String>(id1, item1);
                Schema s2 = new Schema<String>(id2, item2);
                Schema s3 = new Schema<String>(id3, item3);
                this.list.save(s1);
                this.list.save(s2);
                this.list.save(s3);

                ArrayList<Schema> items = this.list.get_all_items();
                assert_that(items.get(0).equals(s1)).is(true);
                assert_that(items.get(2).equals(s3)).is(true);
                assert_that(items.get(1).equals(s2)).is(true);
            });

            it("updates the new item", () -> {
                String id1 = "Lecture1";
                String item1 = "Digital Design I";

                this.list.save(new Schema<String>(id1, item1));
                this.list.update(id1, new Schema(id1, "Operating Systems"));

                assert_that(this.list.get_by_id(id1).value()).equals_to("Operating Systems");
            });

            it("deletes an item by id", () -> {
                String id1 = "Lecture1";
                String item1 = "Digital Design I";
                String id2 = "Lecture2";
                String item2 = "Digital Design II";

                this.list.save(new Schema<String>(id1, item1));
                this.list.save(new Schema<String>(id2, item2));
                this.list.delete(id1);

                assert_that(this.list.get_all_items().size()).is(1);
                assert_that(this.list.get_by_id(id2).value()).equals_to("Digital Design II");
            });
        });
    }
}
