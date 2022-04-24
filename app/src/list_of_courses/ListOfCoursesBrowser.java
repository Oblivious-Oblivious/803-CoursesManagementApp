package app.src.list_of_courses;

import java.util.ArrayList;

import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

public class ListOfCoursesBrowser {
    private DBMSGateway courses;
    private Sorter sorter;

    public ListOfCoursesBrowser(DBMSGateway courses, Sorter sorter) {
        this.courses = courses;
        this.sorter = sorter;
    }

    public ArrayList<Schema> list_courses() {
        return sorter.sort(courses);
    }
}
