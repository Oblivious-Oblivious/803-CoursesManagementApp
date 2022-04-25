package app.src.list_of_students;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;

public interface StudentSorter {
    public ArrayList<StudentRegistration> sort(Course course);
}
