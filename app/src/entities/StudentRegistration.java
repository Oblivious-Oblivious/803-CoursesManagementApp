package app.src.entities;

public class StudentRegistration {
    public String id;
    public String name;
    public int year_of_registration;
    public int semester;

    public StudentRegistration(
        String id,
        String name,
        int year_of_registration,
        int semester
    ) {
        this.id = id;
        this.name = name;
        this.year_of_registration = year_of_registration;
        this.semester = semester;
    }
}
