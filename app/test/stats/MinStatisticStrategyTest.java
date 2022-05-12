package app.test.stats;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.Grades;
import app.src.entities.Identifiable;
import app.src.entities.StudentRegistration;
import app.src.list_of_students.StudentAdder;
import app.src.grades.GradesAdder;
import app.src.grades.GradesCalculator;
import app.src.stats.MinStatisticStrategy;

import jspec.*;

public class MinStatisticStrategyTest extends SpecModule {
    private Course course;

    public void spec_code() {
        describe("MinStatisticStrategy", () -> {
            before(() -> {
                this.course = new Course(
                    "id",
                    "name",
                    "syllabus",
                    "instructor",
                    "year",
                    "semester"
                );

                StudentAdder student_adder = new StudentAdder(this.course);
                student_adder.add_new_student(
                    "4147",
                    "Ath Pap",
                    "2017",
                    "10"
                );
                student_adder.add_new_student(
                    "4392",
                    "Ath Kour",
                    "2018",
                    "8"
                );
                student_adder.add_new_student(
                    "4333",
                    "Kon Geo",
                    "2018",
                    "8"
                );

                ArrayList<Identifiable> students = this.course.get_students_db().get_all_items();

                GradesAdder grades_adder0 = new GradesAdder((StudentRegistration)students.get(0));
                GradesAdder grades_adder1 = new GradesAdder((StudentRegistration)students.get(1));
                GradesAdder grades_adder2 = new GradesAdder((StudentRegistration)students.get(2));
                grades_adder0.add_new_grades("0_8", "8.0", "2.5", "6");
                grades_adder0.add_new_grades("0_10", "8.0", "7.5", "8");
                grades_adder1.add_new_grades("1_10", "5.0", "8.5", "8");
                grades_adder2.add_new_grades("2_10", "9.5", "10.0", "8");
            });

            it("creates a MinStatisticStrategy object", () -> {
                MinStatisticStrategy min = new MinStatisticStrategy(this.course);
                assert_that(min).isnot(null);
            });

            it("calculates the min statistic out of a set of latest grades", () -> {
                MinStatisticStrategy min = new MinStatisticStrategy(this.course);
                assert_that(min.calculate()).equals_to(7.45);
            });
        });
    }
}
