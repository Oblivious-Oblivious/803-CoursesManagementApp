package client.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.src.entities.Course;
import app.src.entities.Identifiable;
import app.src.entities.RegistrationToken;
/* TODO Fix boundary interface */
// import app.src.boundaries.CourseUpdaterBoundary;
import app.src.list_of_courses.CourseUpdater;

@Controller
public class CourseUpdaterController {
    @PostMapping("/update_course_object")
    public String update_course_object(String courseid, Course course, Model model) {
        /* TODO Get this from outside */
        RegistrationToken token = new RegistrationToken("oblivious", "123");

        CourseUpdater updater = new CourseUpdater(token.get_courses_db(), courseid);
        updater
            .edit_name(course.name)
            .edit_syllabus(course.syllabus)
            .edit_instructor(course.instructor)
            .edit_year(course.year)
            .edit_semester(course.semester)
            .update();

        return "redirect:/courses?username=" + token.username + "&password=" + token.password;
    }

    @GetMapping("/courses/update")
    public String course_updater(@RequestParam("id") String id, Model model) {
        /* TODO Get this from outside */
        RegistrationToken token = new RegistrationToken("oblivious", "123");
        Course course = (Course)token.get_courses_db().get_by_id(id);
        model.addAttribute("course", course);
        return "routes/course_updater";
    }
}
