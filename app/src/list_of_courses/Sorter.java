package app.src.list_of_courses;

import java.util.ArrayList;

import app.src.entities.Schema;
import app.src.entities.DBMSGateway;

public interface Sorter {
    public ArrayList<Schema> sort(DBMSGateway db);
}
