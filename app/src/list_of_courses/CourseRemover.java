package app.src.list_of_courses;

import app.src.entities.DBMSGateway;

public class CourseRemover {
    DBMSGateway courses_db = null;

    public CourseRemover(DBMSGateway courses_db) {
        this.courses_db = courses_db;
    }

    public void remove_course(String id) {
        this.courses_db.delete(id);
    }
}
