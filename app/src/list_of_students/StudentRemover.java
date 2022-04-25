package app.src.list_of_students;

import app.src.entities.Course;

public class StudentRemover {
    private Course course;

    public StudentRemover(Course course) {
        this.course = course;
    }

    public void remove_student(String id) {
        /* TODO Use DBMS here */
        // this.course.students.remove(index)
        for(int i = 0; i < this.course.students.size(); i++)
            if(this.course.students.get(i).id.equals(id))
                this.course.students.remove(i);
    }
}
