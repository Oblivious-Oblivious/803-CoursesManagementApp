package app.test.datamodels;

import jspec.*;
import app.src.datamodels.*;

public class ListOfCoursesTest extends SpecModule {
    private ListOfCourses l = null;

    public void spec_code() {
        describe("List of courses", () -> {
            before_each(() -> {
                this.l = new ListOfCourses();
            });

            it("creates an empty course list", () -> {
                assert_that(this.l.size()).is(0);
            });

            it("adds a course in the list", () -> {
                this.l.add(new Course("Linear Algebra", "Desc", 2017, 1));
                assert_that(this.l.size()).is(1);
            });

            it("adds 3 integergs in the list", () -> {
                this.l.add(new Course("Linear Algebra", "Desc", 2017, 1));
                this.l.add(new Course("Operating Systems I", "Desc2", 2019, 7));
                this.l.add(new Course("Operating Systems II", "Desc3", 2020, 8));

                assert_that(this.l.size()).equals_to(3);
            });

            it("adds an integer then reads the value", () -> {
                this.l.add(new Course("Operating Systems I", "Desc2", 2019, 7));
                this.l.add(new Course("Operating Systems II", "Desc3", 2020, 8));
                Course item1 = l.item_at(0);
                Course item2 = l.item_at(1);

                assert_that(item1.name).equals_to("Operating Systems I");
                assert_that(item2.name).equals_to("Operating Systems II");
            });
        });
    }
}
