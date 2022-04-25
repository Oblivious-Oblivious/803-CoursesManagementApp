package app.test.list_of_students;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;
import app.src.list_of_students.StudentSorter;
import app.src.list_of_students.NameStudentSorter;

import jspec.*;

public class NameStudentSorterTest extends SpecModule {
    private Course course;

    public void spec_code() {
        describe("NameStudentSorter object", () -> {
            before_each(() -> {
                this.course = new Course(
                    "id",
                    "name",
                    "syllabus",
                    "instructor",
                    "year", "semester"
                );

                this.course.students.add(new StudentRegistration(
                    "4147",
                    "Papapostolou",
                    "2017",
                    "10"
                ));
                this.course.students.add(new StudentRegistration(
                    "4392",
                    "Koureas",
                    "2018",
                    "8"
                ));
                this.course.students.add(new StudentRegistration(
                    "4333",
                    "Georgiou",
                    "2018",
                    "8"
                ));
            });

            it("creates a sorter object", () -> {
                StudentSorter name_sorter = new NameStudentSorter();
                assert_that(name_sorter).isnot(null);
            });

            it("sorts the student list by name alphabetically", () -> {
                StudentSorter name_sorter = new NameStudentSorter();
                ArrayList<StudentRegistration> sorted = name_sorter.sort(this.course);

                assert_that(sorted.get(0).name).equals_to("Georgiou");
                assert_that(sorted.get(1).name).equals_to("Koureas");
                assert_that(sorted.get(2).name).equals_to("Papapostolou");
            });
        });
    }
}
