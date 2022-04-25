package app.src.list_of_students;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;

public class StudentBrowser {
    private Course course;

    public StudentBrowser(Course course) {
        this.course = course;
    }

    public ArrayList<StudentRegistration> list_students() {
        return this.course.students;
    }
}
