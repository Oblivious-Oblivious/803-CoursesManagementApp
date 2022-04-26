package app.src.list_of_courses;

import app.src.entities.Course;
import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

public class CourseAdder {
    DBMSGateway courses_db = null;
    
    public CourseAdder(DBMSGateway courses_db) {
        this.courses_db = courses_db;
    }

    public void add_new_course(String id, String name, String syllabus, String instructor, String year, String semester) {
        Schema<Course> new_schema = new Schema<Course>(
            id,
            new Course(id, name, syllabus, instructor, year, semester)
        );
        this.courses_db.save(new_schema);
    }
}
