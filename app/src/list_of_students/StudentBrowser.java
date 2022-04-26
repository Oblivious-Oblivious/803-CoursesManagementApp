package app.src.list_of_students;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.Schema;

public class StudentBrowser {
    private Course course;
    private StudentSorter sorter;

    public StudentBrowser(Course course, StudentSorter sorter) {
        this.course = course;
        this.sorter = sorter;
    }

    public ArrayList<Schema> list_students() {
        return this.sorter.sort(this.course);
    }
}
