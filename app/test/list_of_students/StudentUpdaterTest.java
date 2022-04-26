package app.test.list_of_students;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;

import app.src.list_of_students.StudentUpdater;

import jspec.*;

public class StudentUpdaterTest extends SpecModule {
    private Course test = null;

    public void spec_code() {
        describe("StudentUpdater object", () -> {
            before(() -> {
                this.test = new Course(
                    "id",
                    "name",
                    "syllabus",
                    "instructor",
                    "year", "semester"
                );

                this.test.students.add(new StudentRegistration(
                    "4147",
                    "Ath Pap",
                    "2017",
                    "10"
                ));
                this.test.students.add(new StudentRegistration(
                    "4392",
                    "Ath Kour",
                    "2018",
                    "8"
                ));
                this.test.students.add(new StudentRegistration(
                    "4333",
                    "Kon Geo",
                    "2018",
                    "8"
                ));
            });

            it("creates a student updater object", () -> {
                StudentUpdater updater = new StudentUpdater(this.test, "4147");
                assert_that(updater).isnot(null);
            });

            it("updates the id of a specific student", () -> {
                StudentUpdater updater = new StudentUpdater(this.test, "4147");
                updater
                    .edit_id("4242")
                    .update();
                
                StudentRegistration st = this.test.students.get(0);
                assert_that(st.id).equals_to("4242");
            });

            it("updates all fields using the builder pattern", () -> {
                StudentUpdater updater = new StudentUpdater(this.test, "4333");
                updater
                    .edit_id("new id")
                    .edit_name("new name")
                    .edit_year_of_registration("new year")
                    .edit_semester("new semester")
                    .update();
                
                StudentRegistration st = this.test.students.get(2);
                assert_that(st.id).equals_to("new id");
                assert_that(st.name).equals_to("new name");
                assert_that(st.year_of_registration).equals_to("new year");
                assert_that(st.semester).equals_to("new semester");
            });
        });
    }
}
