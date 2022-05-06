package app.src.list_of_courses;

import java.util.ArrayList;

import app.src.entities.PersistenceGateway;
import app.src.entities.Schema;

public class NullCourseSorter implements CourseSorter {
    @Override
    public ArrayList<Schema> sort(PersistenceGateway db) {
        return db.get_all_items();
    }
}
