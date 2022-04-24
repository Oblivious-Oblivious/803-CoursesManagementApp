package app.src.list_of_courses;

import java.util.ArrayList;

import app.src.entities.Schema;
import app.src.entities.DBMSGateway;

public interface Sorter {
    /* TODO Get null object pattern for sorter as well */
    public ArrayList<Schema> sort(DBMSGateway db);
}
