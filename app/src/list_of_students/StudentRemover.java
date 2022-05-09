package app.src.list_of_students;

import app.src.entities.Course;

public class StudentRemover {
    private Course course;

    public StudentRemover(Course course) {
        this.course = course;
    }

    public void remove_student(String id) {
        this.course.get_students_db().delete(id);
    }
}
