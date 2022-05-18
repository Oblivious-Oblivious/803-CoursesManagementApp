package client.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import app.src.entities.Course;
import app.src.entities.RegistrationToken;
import app.src.boundaries.CourseAdderBoundary;
import app.src.list_of_courses.CourseAdder;

@Controller
public class CourseAdderController {
    @PostMapping("/add_new_course")
    public String add_new_course(Course course) {
        /* TODO Get this from outside */
        RegistrationToken token = new RegistrationToken("oblivious", "123");

        CourseAdderBoundary adder = new CourseAdder(token.get_courses_db());
        adder.add_new_course(
            course.name,
            course.syllabus,
            course.instructor,
            course.year,
            course.semester
        );
        return "redirect:/courses?username=" + token.username + "&password=" + token.password;
    }

    @GetMapping("/courses/add")
    public String course_adder(Model model) {
        Course course = new Course("", "", "", "", "");
        model.addAttribute("course", course);
        return "routes/course_adder";
    }
}
