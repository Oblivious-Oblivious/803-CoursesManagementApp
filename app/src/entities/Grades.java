package app.src.entities;

import java.io.Serializable;

public class Grades implements Serializable {
    public double project;
    public double exam;
    public String semester;

    public Grades(double project, double exam, String semester) {
        this.project = project;
        this.exam = exam;
        this.semester = semester;
    }
}
