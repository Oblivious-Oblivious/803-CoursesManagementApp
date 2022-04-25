package app.src.list_of_students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import app.src.entities.Course;
import app.src.entities.StudentRegistration;

public class NameStudentSorter implements StudentSorter {
    @Override
    public ArrayList<StudentRegistration> sort(Course course) {
        ArrayList<StudentRegistration> sorted = course.students;
        
        Collections.sort(sorted, new Comparator<StudentRegistration>() {
            public int compare(StudentRegistration s1, StudentRegistration s2) {
                return s1.compare_names(s2);
            }
        });

        return sorted;
    }
}
