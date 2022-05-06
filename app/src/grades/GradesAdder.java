package app.src.grades;

import app.src.entities.Grades;
import app.src.entities.Schema;
import app.src.entities.StudentRegistration;

public class GradesAdder {
    private StudentRegistration reg;

    public GradesAdder(StudentRegistration reg) {
        this.reg = reg;
    }

    public void add_new_grades(String id, String project, String exam, String semester) {
        Schema<Grades> new_schema = new Schema<Grades>(
            id,
            new Grades(project, exam, semester)
        );

        this.reg.grades_db.save(new_schema);
    }
}
