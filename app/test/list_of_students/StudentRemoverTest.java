package app.test.list_of_students;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;

import app.src.list_of_students.StudentRemover;

import jspec.*;

public class StudentRemoverTest extends SpecModule {
    private Course test = null;

    public void spec_code() {
        describe("StudentRemover object", () -> {
            before(() -> {
                this.test = new Course(
                    "id",
                    "name",
                    "syllabus",
                    "instructor",
                    "year", "semester"
                );

                this.test.get_students_db().save(new StudentRegistration(
                    "4147",
                    "Ath Pap",
                    "2017",
                    "10"
                ));
                this.test.get_students_db().save(new StudentRegistration(
                    "4392",
                    "Ath Kour",
                    "2018",
                    "8"
                ));
                this.test.get_students_db().save(new StudentRegistration(
                    "4333",
                    "Kon Geo",
                    "2018",
                    "8"
                ));
            });

            it("creates a student remover object", () -> {
                StudentRemover remover = new StudentRemover(this.test);
                assert_that(remover).isnot(null);
            });

            it("removes a student from the list", () -> {
                StudentRemover remover = new StudentRemover(this.test);
                remover.remove_student("4392");

                assert_that(this.test.get_students_db().get_all_items().size()).equals_to(2);
                assert_that(((StudentRegistration)(this.test.get_students_db().get_all_items().get(0))).id).equals_to("4147");
                assert_that(((StudentRegistration)(this.test.get_students_db().get_all_items().get(1))).id).equals_to("4333");
            });
        });
    }
}
