package app.test.list_of_students;

import app.src.entities.Course;
import app.src.entities.Schema;
import app.src.entities.StudentRegistration;

import app.src.list_of_students.StudentAdder;

import jspec.*;

public class StudentAdderTest extends SpecModule {
    private Course test;

    public void spec_code() {
        describe("StudentAdder object", () -> {
            before(() -> {
                this.test = new Course(
                    "id",
                    "name",
                    "syllabus",
                    "instructor",
                    "year", "semester"
                );

                this.test.students_db.save(new Schema("4147", new StudentRegistration(
                    "4147",
                    "Ath Pap",
                    "2017",
                    "10"
                )));
                this.test.students_db.save(new Schema("4392", new StudentRegistration(
                    "4392",
                    "Ath Kour",
                    "2018",
                    "8"
                )));
                this.test.students_db.save(new Schema("4333", new StudentRegistration(
                    "4333",
                    "Kon Geo",
                    "2018",
                    "8"
                )));
            });

            it("creates a student adder object", () -> {
                StudentAdder adder = new StudentAdder(this.test);
                assert_that(adder).isnot(null);
            });

            it("adds a new object to the list of students", () -> {
                StudentAdder adder = new StudentAdder(this.test);
                adder.add_new_student(
                    "9999",
                    "Test Name",
                    "2014",
                    "17"
                );

                assert_that(this.test.students_db.get_all_items().size()).equals_to(4);
                assert_that(((StudentRegistration)(this.test.students_db.get_by_id("9999").value())).name).equals_to("Test Name");
            });
        });
    }
}
