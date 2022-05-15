package app.src.boundaries;

/* TODO Make id be generated automatically on identifiable */
public interface CourseAdderBoundary {
    public void add_new_course(String id, String name, String syllabus, String instructor, String year, String semester);
}
