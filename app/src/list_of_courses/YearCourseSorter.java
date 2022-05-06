package app.src.list_of_courses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import app.src.entities.Course;
import app.src.entities.PersistenceGateway;
import app.src.entities.Schema;

public class YearCourseSorter implements CourseSorter {
    @Override
    public ArrayList<Schema> sort(PersistenceGateway db) {
        ArrayList<Schema> sorted = db.get_all_items();

        Collections.sort(sorted, new Comparator<Schema>() {
            public int compare(Schema s1, Schema s2) {
                Course c1 = (Course)s1.value();
                Course c2 = (Course)s2.value();
                return c1.compare_years(c2);
            }
        });

        return sorted;
    }
}
