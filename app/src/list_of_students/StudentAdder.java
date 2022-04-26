package app.src.list_of_students;

import app.src.entities.Course;
import app.src.entities.Schema;
import app.src.entities.StudentRegistration;

public class StudentAdder {
    private Course course;

    public StudentAdder(Course course) {
        this.course = course;
    }

    public void add_new_student(String id, String name, String year_of_registration, String semester) {
        Schema<StudentRegistration> new_schema = new Schema<StudentRegistration>(
            id,
            new StudentRegistration(id, name, year_of_registration, semester)
        );
        this.course.students_db.save(new_schema);
    }
}
