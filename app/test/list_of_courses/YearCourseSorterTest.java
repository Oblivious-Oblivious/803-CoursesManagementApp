package app.test.list_of_courses;

import java.util.ArrayList;

import app.src.list_of_courses.CourseSorter;
import app.src.list_of_courses.YearCourseSorter;

import app.src.entities.Course;
import app.src.entities.PersistenceGateway;
import app.src.entities.Identifiable;

import persistence.CustomGatewayImplementation;

import jspec.*;

public class YearCourseSorterTest extends SpecModule {
    private PersistenceGateway courses;

    public void spec_code() {
        before_each(() -> {
            this.courses = new CustomGatewayImplementation("Courses");
            this.courses.save(new Course(
                "c1",
                "Digital Design I",
                "Some info about ditital design 1",
                "Kavousianos",
                "2020",
                "3"
            ));
            this.courses.save(new Course(
                "c2",
                "Software Engineering",
                "More info about S. E.",
                "Zarras",
                "2022",
                "8"
            ));
            this.courses.save(new Course(
                "c3",
                "Operating Systems",
                "OS class information and syllabus",
                "Anastasiadis",
                "2021",
                "7"
            ));
        });

        describe("YearCourseSorter", () -> {
            it("creates a sorter object", () -> {
                CourseSorter year_sorter = new YearCourseSorter();
                assert_that(year_sorter).isnot(null);
            });

            it("sorts the db by year", () -> {
                CourseSorter year_sorter = new YearCourseSorter();
                ArrayList<Identifiable> sorted = year_sorter.sort(this.courses);

                Course anastasiadis = new Course("c3", "Operating Systems", "OS class information and syllabus", "Anastasiadis", "2021", "7");
                Course kavousianos = new Course("c1", "Digital Design I", "Some info about ditital design 1", "Kavousianos", "2020", "3");
                Course zarras = new Course("c2", "Software Engineering", "More info about S. E.", "Zarras", "2022", "8");

                assert_that(((Course)(sorted.get(0))).equals(kavousianos)).is(true);
                assert_that(((Course)(sorted.get(1))).equals(anastasiadis)).is(true);
                assert_that(((Course)(sorted.get(2))).equals(zarras)).is(true);
            });
        });
    }
}
