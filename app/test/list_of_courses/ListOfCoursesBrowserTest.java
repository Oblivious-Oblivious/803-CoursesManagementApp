package app.test.list_of_courses;

import java.util.ArrayList;

import app.src.list_of_courses.ListOfCoursesBrowser;
import app.src.list_of_courses.InstructorSorter;

import app.src.entities.Course;
import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

import dbms.CustomGatewayImplementation;

import jspec.*;

public class ListOfCoursesBrowserTest extends SpecModule {
    private DBMSGateway courses;
    private Course anastasiadis;
    private Course kavousianos;
    private Course zarras;

    public void spec_code() {
        before_each(() -> {
            this.kavousianos = new Course(
                "c1",
                "Digital Design I",
                "Some info about ditital design 1",
                "Kavousianos",
                "2020",
                "3"
            );
            this.zarras = new Course(
                "c2",
                "Software Engineering",
                "More info about S. E.",
                "Zarras",
                "2022",
                "8"
            );
            this.anastasiadis = new Course(
                "c3",
                "Operating Systems",
                "OS class information and syllabus",
                "Anastasiadis",
                "2021",
                "7"
            );

            this.courses = new CustomGatewayImplementation("Courses");
            this.courses.save(new Schema("c1", kavousianos));
            this.courses.save(new Schema("c2", zarras));
            this.courses.save(new Schema("c3", anastasiadis));
        });

        describe("ListOfCoursesBrowser", () -> {
            it("creates a list browser object", () -> {
                ListOfCoursesBrowser browser = new ListOfCoursesBrowser(
                    this.courses,
                    new InstructorSorter()
                );
            });

            it("returns a list of courses sorted according to the injected sorter", () -> {
                ListOfCoursesBrowser browser = new ListOfCoursesBrowser(
                    this.courses,
                    new InstructorSorter()
                );

                ArrayList<Schema> list = browser.list_courses();
                assert_that(((Course)(list.get(0).value())).equals(this.anastasiadis)).is(true);
                assert_that(((Course)(list.get(1).value())).equals(this.kavousianos)).is(true);
                assert_that(((Course)(list.get(2).value())).equals(this.zarras)).is(true);
            });
        });
    }
}
