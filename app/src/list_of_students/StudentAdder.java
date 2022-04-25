package app.src.list_of_students;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;

public class StudentAdder {
    private Course course;

    public StudentAdder(Course course) {
        this.course = course;
    }

    public void add_new_student(StudentRegistration new_student) {
        this.course.students.add(new_student);
    }
}
