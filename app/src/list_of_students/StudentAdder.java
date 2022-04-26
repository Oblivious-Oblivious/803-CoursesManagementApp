package app.src.list_of_students;

import app.src.entities.Course;
import app.src.entities.Schema;
import app.src.entities.StudentRegistration;

public class StudentAdder {
    private Course course;

    public StudentAdder(Course course) {
        this.course = course;
    }

    public void add_new_student(StudentRegistration new_student) {
        Schema<StudentRegistration> new_schema = new Schema<StudentRegistration>(new_student.id, new_student);
        this.course.students_db.save(new_schema);
    }
}
