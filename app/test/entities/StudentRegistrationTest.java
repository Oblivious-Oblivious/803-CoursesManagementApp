package app.test.entities;

import app.src.entities.StudentRegistration;
import jspec.*;

public class StudentRegistrationTest extends SpecModule {
    private StudentRegistration r = null;

    public void spec_code() {
        describe("StudentRegistration object", () -> {
            before_each(() -> {
                String id = "04147";
                String name = "Oblivious";
                String year_of_registration = "2021";
                String semester = "8";

                this.r = new StudentRegistration(id, name, year_of_registration, semester);
            });

            it("creates a random student object with passed data", () -> {
                assert_that(r.id).equals_to("04147");
                assert_that(r.name).equals_to("Oblivious");
                assert_that(r.year_of_registration).equals_to("2021");
                assert_that(r.semester).equals_to("8");
            });
        });
    }
}
