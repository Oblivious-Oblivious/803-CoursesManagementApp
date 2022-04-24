package app.src.list_of_courses;

import java.util.ArrayList;

import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

public interface CourseSorter {
    /* TODO Get null object pattern for sorter as well */
    public ArrayList<Schema> sort(DBMSGateway db);
}
