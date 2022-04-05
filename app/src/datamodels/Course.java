package app.src.datamodels;

public class Course {
    public String name;
    public String syllabus;
    public int year;
    public int semester;

    public Course(String name, String syllabus, int year, int semester) {
        this.name = name;
        this.syllabus = syllabus;
        this.year = year;
        this.semester = semester;
    }

    public void update(String name, String syllabus, int year, int semester) {
        this.name = name;
        this.syllabus = syllabus;
        this.year = year;
        this.semester = semester;
    }
}
