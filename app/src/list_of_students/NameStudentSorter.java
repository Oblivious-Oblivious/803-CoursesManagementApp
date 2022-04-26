package app.src.list_of_students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import app.src.entities.Course;
import app.src.entities.Schema;
import app.src.entities.StudentRegistration;

public class NameStudentSorter implements StudentSorter {
    @Override
    public ArrayList<Schema> sort(Course course) {
        ArrayList<Schema> sorted = course.students_db.get_all_items();
        
        Collections.sort(sorted, new Comparator<Schema>() {
            public int compare(Schema s1, Schema s2) {
                StudentRegistration r1 = (StudentRegistration)s1.value();
                StudentRegistration r2 = (StudentRegistration)s2.value();
                return r1.compare_names(r2);
            }
        });

        return sorted;
    }
}
