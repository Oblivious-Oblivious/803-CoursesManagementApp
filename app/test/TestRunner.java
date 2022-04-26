package app.test;

import jspec.*;

import app.test.entities.*;
import app.test.list_of_courses.*;
import app.test.list_of_students.*;
import app.test.login.*;

public class TestRunner {
    public static void main(String args[]) {
        /* TODO Add boundary interfaces */
        SpecModule modules[] = {
            new CourseTest(),
            new SchemaTest(),
            new StudentRegistrationTest(),

            new CourseAdderTest(),
            new CourseBrowserTest(),
            new CourseRemoverTest(),
            new CourseUpdaterTest(),
            new IdCourseSorterTest(),
            new InstructorCourseSorterTest(),
            new NameCourseSorterTest(),
            new NullCourseSorterTest(),
            new SemesterCourseSorterTest(),
            new SyllabusCourseSorterTest(),
            new YearCourseSorterTest(),
            
            new IdStudentSorterTest(),
            new NameStudentSorterTest(),
            new NullStudentSorterTest(),
            new SemesterStudentSorterTest(),
            new StudentAdderTest(),
            new StudentBrowserTest(),
            new StudentRemoverTest(),
            new StudentUpdaterTest(),
            new YearOfRegistrationStudentSorterTest(),

            new ProfessorLoginTest(),
            new ProfessorRegistrationTest(),
            new RegistrationTokenTest(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
