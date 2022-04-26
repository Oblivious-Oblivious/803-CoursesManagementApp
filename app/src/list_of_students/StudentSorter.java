package app.src.list_of_students;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.Schema;

public interface StudentSorter {
    public ArrayList<Schema> sort(Course course);
}
