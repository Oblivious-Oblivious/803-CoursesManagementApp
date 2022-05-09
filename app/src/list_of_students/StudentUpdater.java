package app.src.list_of_students;

import app.src.entities.Course;
import app.src.entities.Schema;
import app.src.entities.StudentRegistration;

public class StudentUpdater {
    private Course course;
    private String id;
    private StudentRegistration current_edited_student;

    public StudentUpdater(Course course, String id) {
        this.course = course;
        this.id = id;
        this.current_edited_student = (StudentRegistration)this.course.get_students_db().get_by_id(id).value();
    }

    public StudentUpdater edit_id(String new_id) {
        this.current_edited_student.id = new_id;
        return this;
    }

    public StudentUpdater edit_name(String new_name) {
        this.current_edited_student.name = new_name;
        return this;
    }

    public StudentUpdater edit_year_of_registration(String new_year) {
        this.current_edited_student.year_of_registration = new_year;
        return this;
    }

    public StudentUpdater edit_semester(String new_semester) {
        this.current_edited_student.semester = new_semester;
        return this;
    }

    public void update() {
        this.course.get_students_db().update(
            this.id,
            new Schema<StudentRegistration>(this.id, this.current_edited_student)
        );
    }
}
