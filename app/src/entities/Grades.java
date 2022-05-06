package app.src.entities;

import java.io.Serializable;

public class Grades implements Serializable {
    public String project;
    public String exam;
    public String semester;

    public Grades(String project, String exam, String semester) {
        this.project = project;
        this.exam = exam;
        this.semester = semester;
    }
}
