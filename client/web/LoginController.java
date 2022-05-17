package client.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import app.src.entities.Identifiable;
import app.src.entities.RegistrationToken;
import app.src.boundaries.LoginBoundary;
import app.src.login.ProfessorLogin;

import persistence.SqliteGatewayImplementation;

@Controller
public class LoginController {
    @PostMapping("/authenticate_credentials")
    public String authenticate_credentials(RegistrationToken reg) {
        LoginBoundary checker = new ProfessorLogin(reg, new SqliteGatewayImplementation("Accounts"));
        if(checker.login())
            return "routes/course_browser";
        return "redirect:/login";
        /* TODO Add a message dialog that rejects invalid inputs */
    }

    @GetMapping("/login")
    public String login(Model model) {
        RegistrationToken reg = new RegistrationToken("", "");
        model.addAttribute("reg", reg);
        return "routes/login";
    }
}
