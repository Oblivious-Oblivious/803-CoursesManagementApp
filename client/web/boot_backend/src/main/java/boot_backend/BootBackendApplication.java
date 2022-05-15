package boot_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootBackendApplication.class, args);
    }

    // @GetMapping("/register")
    // public String register() {
    //     return "REGISTER PAGE";
    // }

    // @GetMapping("/login")
    // public String login() {
    //     return "LOGIN PAGE";
    // }

    // @GetMapping("/courses")
    // public String courses() {
    //     return "COURSES PAGE";
    // }

    // @GetMapping("/course/{id}")
    // public String course() {
    //     return "COURSES PAGE";
    // }

    // @GetMapping(value = "/course/{cid}/student/{sid}")
    // public String student(@PathVariable String cid, @PathVariable String sid) {
    //     return "(COURSE,STUDENT) : (" + cid + "," + sid + ")";
    // }
}
