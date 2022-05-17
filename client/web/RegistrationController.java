package client.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import app.src.entities.RegistrationToken;
import app.src.boundaries.RegisterBoundary;
import app.src.login.ProfessorRegistration;

import persistence.SqliteGatewayImplementation;

@Controller
public class RegistrationController {
    @PostMapping("/save_registration_token")
    public String save_registration_token(RegistrationToken reg) {
        RegisterBoundary checker = new ProfessorRegistration(reg, new SqliteGatewayImplementation("Accounts"));
        if(checker.register())
            return "routes/course_browser";
        return "redirect:/register";
        /* TODO Add a message dialog that rejects invalid inputs */
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegistrationToken reg = new RegistrationToken("", "");
        model.addAttribute("reg", reg);
        return "routes/register";
    }
}
