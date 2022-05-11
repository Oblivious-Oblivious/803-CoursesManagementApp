package app.src.grades;

import app.src.entities.Grades;
import app.src.entities.StudentRegistration;

public class GradesAdder {
    private StudentRegistration reg;

    public GradesAdder(StudentRegistration reg) {
        this.reg = reg;
    }

    public void add_new_grades(String id, String project, String exam, String semester) {
        this.reg.get_grades_db().save(new Grades(
            id,
            project,
            exam,
            semester
        ));
    }
}
