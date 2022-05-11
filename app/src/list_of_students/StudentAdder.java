package app.src.list_of_students;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;

public class StudentAdder {
    private Course course;

    public StudentAdder(Course course) {
        this.course = course;
    }

    public void add_new_student(String id, String name, String year_of_registration, String semester) {
        this.course.get_students_db().save(new StudentRegistration(
            id,
            name,
            year_of_registration,
            semester
        ));
    }
}
