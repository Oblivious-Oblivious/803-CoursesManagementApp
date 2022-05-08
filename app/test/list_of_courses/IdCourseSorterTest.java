package app.test.list_of_courses;

import java.util.ArrayList;

import app.src.list_of_courses.CourseSorter;
import app.src.list_of_courses.IdCourseSorter;

import app.src.entities.Course;
import app.src.entities.PersistenceGateway;
import app.src.entities.Schema;

import persistence.CustomGatewayImplementation;

import jspec.*;

public class IdCourseSorterTest extends SpecModule {
    private PersistenceGateway courses;

    public void spec_code() {
        before_each(() -> {
            this.courses = new CustomGatewayImplementation("Courses");
            this.courses.save(new Schema("c1", new Course(
                "c1",
                "Digital Design I",
                "Some info about ditital design 1",
                "Kavousianos",
                "2020",
                "3"
            )));
            this.courses.save(new Schema("c2", new Course(
                "c2",
                "Software Engineering",
                "More info about S. E.",
                "Zarras",
                "2022",
                "8"
            )));
            this.courses.save(new Schema("c3", new Course(
                "c3",
                "Operating Systems",
                "OS class information and syllabus",
                "Anastasiadis",
                "2021",
                "7"
            )));
        });

        describe("IdCourseSorter", () -> {
            it("creates a sorter object", () -> {
                CourseSorter id_sorter = new IdCourseSorter();
                assert_that(id_sorter).isnot(null);
            });

            it("sorts the db by id", () -> {
                CourseSorter id_sorter = new IdCourseSorter();
                ArrayList<Schema> sorted = id_sorter.sort(this.courses);

                Course anastasiadis = new Course("c3", "Operating Systems", "OS class information and syllabus", "Anastasiadis", "2021", "7");
                Course kavousianos = new Course("c1", "Digital Design I", "Some info about ditital design 1", "Kavousianos", "2020", "3");
                Course zarras = new Course("c2", "Software Engineering", "More info about S. E.", "Zarras", "2022", "8");

                assert_that(((Course)(sorted.get(0).value())).equals(kavousianos)).is(true);
                assert_that(((Course)(sorted.get(1).value())).equals(zarras)).is(true);
                assert_that(((Course)(sorted.get(2).value())).equals(anastasiadis)).is(true);
            });
        });
    }
}
