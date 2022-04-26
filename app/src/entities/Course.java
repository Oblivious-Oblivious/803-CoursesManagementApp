package app.src.entities;

import java.io.Serializable;

import dbms.CustomGatewayImplementation;

public class Course implements Serializable {
    public String id;
    public String name;
    public String syllabus;
    public String instructor;
    public String year;
    public String semester;
    
    /* TODO transient specific only to CustomDB */
    public transient DBMSGateway students_db;

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

        /* TODO Figure out way to inject this */
        this.students_db = new CustomGatewayImplementation("Students");
    }

    public int compare_ids(Course other) {
        return this.id.compareTo(other.id);
    }

    public int compare_names(Course other) {
        return this.name.compareTo(other.name);
    }

    public int compare_syllabi(Course other) {
        return this.syllabus.compareTo(other.syllabus);
    }

    public int compare_instructors(Course other) {
        return this.instructor.compareTo(other.instructor);
    }

    public int compare_years(Course other) {
        return this.year.compareTo(other.year);
    }

    public int compare_semesters(Course other) {
        return this.semester.compareTo(other.semester);
    }

    public boolean equals(Course other) {
        return this.id.equals(other.id)
            && this.name.equals(other.name)
            && this.syllabus.equals(other.syllabus)
            && this.instructor.equals(other.instructor)
            && this.year.equals(other.year)
            && this.semester.equals(other.semester);
    }
}
