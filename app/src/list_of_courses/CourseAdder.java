package app.src.list_of_courses;

import app.src.entities.Course;
import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

public class CourseAdder {
    DBMSGateway courses_db = null;
    
    public CourseAdder(DBMSGateway courses_db) {
        this.courses_db = courses_db;
    }

    public void add_new_course(Course new_course) {
        Schema<Course> new_schema = new Schema<Course>(new_course.id, new_course);
        this.courses_db.save(new_schema);
    }
}
