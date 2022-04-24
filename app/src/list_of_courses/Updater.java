package app.src.list_of_courses;

import app.src.entities.Course;
import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

public class Updater {
    private DBMSGateway courses_db;
    private Course current_edited_course;

    public Updater(DBMSGateway courses_db, String id) {
        this.courses_db = courses_db;
        this.current_edited_course = (Course)this.courses_db.get_by_id(id).value();
    }

    public Updater edit_name(String new_name) {
        this.current_edited_course.name = new_name;
        return this;
    }

    public Updater edit_syllabus(String new_syllabus) {
        this.current_edited_course.syllabus = new_syllabus;
        return this;
    }

    public Updater edit_instructor(String new_instructor) {
        this.current_edited_course.instructor = new_instructor;
        return this;
    }

    public Updater edit_year(String new_year) {
        this.current_edited_course.year = new_year;
        return this;
    }

    public Updater edit_semester(String new_semester) {
        this.current_edited_course.semester = new_semester;
        return this;
    }

    public void update() {
        this.courses_db.update(
            this.current_edited_course.id,
            new Schema<Course>(this.current_edited_course.id, current_edited_course)
        );
    }
}
