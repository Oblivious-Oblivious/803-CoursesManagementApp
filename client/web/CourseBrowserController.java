package client.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.src.boundaries.CourseBrowserBoundary;

import app.src.entities.Course;
import app.src.entities.PersistenceGateway;
import app.src.entities.RegistrationToken;

import app.src.list_of_courses.CourseBrowser;
import app.src.list_of_courses.NameCourseSorter;

import persistence.SqliteGatewayImplementation;

@Controller
public class CourseBrowserController {
    @GetMapping("/courses")
    public String course_browser(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        Model model
    ) {
        RegistrationToken token = new RegistrationToken(username, password);
        CourseBrowserBoundary browser = new CourseBrowser(token.get_courses_db(), new NameCourseSorter());
        model.addAttribute("course_list", browser.list_courses());
        return "routes/course_browser";
    }
}
