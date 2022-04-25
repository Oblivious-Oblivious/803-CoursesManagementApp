package app.test.list_of_students;

import app.src.entities.Course;
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

            it("creates a student adder object", () -> {
                StudentAdder adder = new StudentAdder(this.test);
                assert_that(adder).isnot(null);
            });

            it("adds a new object to the list of students", () -> {
                StudentAdder adder = new StudentAdder(this.test);
                /* TODO Refactor into passing only data in (no object knowledge needed) */
                adder.add_new_student(new StudentRegistration(
                    "9999",
                    "Test Name",
                    "2014",
                    "17"
                ));

                assert_that(this.test.students.size()).equals_to(4);
                assert_that(this.test.students.get(3).name).equals_to("Test Name");
            });
        });
    }
}
