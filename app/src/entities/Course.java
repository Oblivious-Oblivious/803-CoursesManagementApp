package app.src.entities;

import java.util.ArrayList;
import java.io.Serializable;

public class Course implements Serializable {
    public String id;
    public String name;
    public String syllabus;
    public String instructor;
    public String year;
    public String semester;

    public ArrayList<StudentRegistration> students;

    public Course(
        String id,
        String name,
        String syllabus,
        String instructor,
        String year,
        String semester
    ) {
        this.id = id;
        this.name = name;
        this.syllabus = syllabus;
        this.instructor = instructor;
        this.year = year;
        this.semester = semester;

        /* TODO Implement DBSM operations */
        this.students = new ArrayList<StudentRegistration>();
    }

    public int compare_instructors(Course other) {
        return this.instructor.compareTo(other.instructor);
    }

    public boolean equals(Course other) {
        return this.id.equals(other.id)
            && this.name.equals(other.name)
            && this.syllabus.equals(other.syllabus)
            && this.instructor.equals(other.instructor)
            && this.year.equals(other.year)
            && this.semester.equals(other.semester)
            && this.students.equals(other.students);
    }
}
