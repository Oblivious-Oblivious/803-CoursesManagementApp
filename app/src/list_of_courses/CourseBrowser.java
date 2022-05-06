package app.src.list_of_courses;

import java.util.ArrayList;

import app.src.entities.PersistenceGateway;
import app.src.entities.Schema;

public class CourseBrowser {
    private PersistenceGateway courses;
    private CourseSorter sorter;

    public CourseBrowser(PersistenceGateway courses, CourseSorter sorter) {
        this.courses = courses;
        this.sorter = sorter;
    }

    public ArrayList<Schema> list_courses() {
        return sorter.sort(courses);
    }
}
