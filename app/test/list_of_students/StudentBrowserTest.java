package app.test.list_of_students;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;
import app.src.list_of_students.StudentBrowser;

import jspec.*;

public class StudentBrowserTest extends SpecModule {
    private Course test = null;

    public void spec_code() {
        describe("StudentBrowser object", () -> {
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

            it("creates a student browser object", () -> {
                StudentBrowser browser = new StudentBrowser(this.test);
                assert_that(browser).isnot(null);
            });

            it("returns a list of all students in a particular course", () -> {
                StudentBrowser browser = new StudentBrowser(this.test);
                ArrayList<StudentRegistration> list = browser.list_students();

                assert_that(list.size()).equals_to(3);
                assert_that(list.get(0).id).equals_to("4147");
            });
        });
    }
}
