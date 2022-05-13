package app.src.entities;

import persistence.SqliteGatewayImplementation;

public class StudentRegistration extends Identifiable {
    public String name;
    public String year_of_registration;
    public String semester;

    private transient PersistenceGateway grades_db;

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

        /* TODO Try to inject this */
        this.grades_db = new SqliteGatewayImplementation("Grades_" + this.id);
    }

    public PersistenceGateway get_grades_db() {
        if(this.grades_db == null)
            this.grades_db = new SqliteGatewayImplementation("Grades_" + this.id);
        return this.grades_db;
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
        /* TODO String version has a logic error */
        return Integer.compare(Integer.parseInt(this.semester), Integer.parseInt(other.semester));
    }

    @Override
    public boolean is(Identifiable o) {
        StudentRegistration other=  (StudentRegistration)o;
        return this.name.equals(other.name)
            && this.year_of_registration.equals(other.year_of_registration)
            && this.semester.equals(other.semester);
    }

    @Override
    public String toString() {
        return "";
    }
}
