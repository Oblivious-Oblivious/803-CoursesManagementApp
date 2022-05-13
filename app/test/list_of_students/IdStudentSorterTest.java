package app.test.list_of_students;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.Identifiable;
import app.src.entities.StudentRegistration;

import app.src.list_of_students.StudentSorter;
import app.src.list_of_students.IdStudentSorter;

import jspec.*;

public class IdStudentSorterTest extends SpecModule {
    private Course course;

    public void spec_code() {
        describe("IdStudentSorter object", () -> {
            before(() -> {
                this.course = new Course(
                    "id",
                    "name",
                    "syllabus",
                    "instructor",
                    "year", "semester"
                );

                this.course.get_students_db().save(new StudentRegistration(
                    "4147",
                    "Papapostolou",
                    "2017",
                    "10"
                ));
                this.course.get_students_db().save(new StudentRegistration(
                    "4392",
                    "Koureas",
                    "2018",
                    "8"
                ));
                this.course.get_students_db().save(new StudentRegistration(
                    "4333",
                    "Georgiou",
                    "2019",
                    "6"
                ));
            });

            it("creates a sorter object", () -> {
                StudentSorter id_sorter = new IdStudentSorter();
                assert_that(id_sorter).isnot(null);
            });

            it("sorts the student list by id", () -> {
                StudentSorter id_sorter = new IdStudentSorter();
                ArrayList<Identifiable> sorted = id_sorter.sort(this.course);

                assert_that(((StudentRegistration)(sorted.get(0))).name).equals_to("Papapostolou");
                assert_that(((StudentRegistration)(sorted.get(1))).name).equals_to("Georgiou");
                assert_that(((StudentRegistration)(sorted.get(2))).name).equals_to("Koureas");
            });

            after(() -> {
                new java.io.File("persistence/sqlite/src/Database.db").delete();
            });
        });
    }
}
