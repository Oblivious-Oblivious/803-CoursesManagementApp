package client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.src.entities.RegistrationToken;
import app.src.boundaries.CourseRemoverBoundary;
import app.src.list_of_courses.CourseRemover;

@Controller
public class CourseRemoverController {
    @GetMapping("/courses/remove")
    public String course_remover(@RequestParam("id") String id) {
        /* TODO Get this from outside */
        RegistrationToken token = new RegistrationToken("oblivious", "123");

        CourseRemoverBoundary remover = new CourseRemover(token.get_courses_db());
        remover.remove_course(id);

        return "redirect:/courses?username=" + token.username + "&password=" + token.password;
    }
}
