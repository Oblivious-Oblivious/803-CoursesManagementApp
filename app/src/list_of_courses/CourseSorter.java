package app.src.list_of_courses;

import java.util.ArrayList;

import app.src.entities.PersistenceGateway;
import app.src.entities.Schema;

public interface CourseSorter {
    public ArrayList<Schema> sort(PersistenceGateway db);
}
