package app.src.entities;

public class Grades extends Identifiable {
    public String project;
    public String exam;
    public String semester;

    public Grades(String id, String project, String exam, String semester) {
        this.id = id;
        this.project = project;
        this.exam = exam;
        this.semester = semester;
    }

    @Override
    public boolean is(Identifiable o) {
        Grades other = (Grades)o;
        return this.project.equals(other.project)
            && this.exam.equals(other.exam)
            && this.semester.equals(other.semester);
    }

    @Override
    public String toString() {
        return "";
    }
}
