package app.src.entities;

import java.io.Serializable;

public class StudentRegistration implements Serializable {
    public String id;
    public String name;
    public String year_of_registration;
    public String semester;

    public StudentRegistration(
        String id,
        String name,
        String year_of_registration,
        String semester
    ) {
        this.id = id;
        this.name = name;
        this.year_of_registration = year_of_registration;
        this.semester = semester;
    }

    public int compare_ids(StudentRegistration other) {
        return this.id.compareTo(other.id);
    }

    public int compare_names(StudentRegistration other) {
        return this.name.compareTo(other.name);
    }

    public int compare_years_of_registration(StudentRegistration other) {
        return this.year_of_registration.compareTo(other.year_of_registration);
    }

    public int compare_semesters(StudentRegistration other) {
        return this.semester.compareTo(other.semester);
    }
}
