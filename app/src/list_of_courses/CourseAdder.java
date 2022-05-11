package app.src.list_of_courses;

import app.src.entities.Course;
import app.src.entities.PersistenceGateway;

public class CourseAdder {
    PersistenceGateway courses_db = null;
    
    public CourseAdder(PersistenceGateway courses_db) {
        this.courses_db = courses_db;
    }

    public void add_new_course(String id, String name, String syllabus, String instructor, String year, String semester) {
        this.courses_db.save(new Course(
            id,
            name,
            syllabus,
            instructor,
            year,
            semester
        ));
    }
}
