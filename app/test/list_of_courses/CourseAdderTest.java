package app.test.list_of_courses;

import app.src.entities.Course;
import app.src.entities.PersistenceGateway;

import app.src.list_of_courses.CourseAdder;

import persistence.CustomGatewayImplementation;

import jspec.*;

public class CourseAdderTest extends SpecModule {
    private PersistenceGateway courses;
    private Course anastasiadis;
    private Course kavousianos;
    private Course zarras;

    public void spec_code() {
        before(() -> {
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
            this.courses.save(kavousianos);
            this.courses.save(zarras);
            this.courses.save(anastasiadis);
        });

        describe("Adder object", () -> {
            it("creates a new Adder object", () -> {
                CourseAdder ad = new CourseAdder(this.courses);
                assert_that(ad).isnot(null);
            });

            it("adds a new course in the course list", () -> {
                CourseAdder ad = new CourseAdder(this.courses);
                Course mamoulis = new Course(
                    "c99",
                    "Introduction to Programming",
                    "Python introduction, iterations, conditionals, asasignments",
                    "Mamoulis",
                    "2021",
                    "1"
                );

                ad.add_new_course(
                    "c99",
                    "Introduction to Programming",
                    "Python introduction, iterations, conditionals, asasignments",
                    "Mamoulis",
                    "2021",
                    "1"
                );

                assert_that(this.courses.get_all_items().size()).equals_to(4);

                Course last_course = (Course)this.courses.get_by_id("c99");
                assert_that(last_course.equals(mamoulis)).is(true);
            });

            after(() -> {
                new java.io.File("persistence/sqlite/src/Database.db").delete();
            });
        });
    }
}
