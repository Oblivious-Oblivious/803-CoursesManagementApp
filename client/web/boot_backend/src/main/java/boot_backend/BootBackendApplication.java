package boot_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootBackendApplication.class, args);
    }

    @GetMapping("/")
    public String root() {
        /* TODO Implement html */
        return "HOMEPAGE";
    }

    @GetMapping("/register")
    public String register() {
        /* TODO Implement html */
        return "REGISTER PAGE";
    }

    @GetMapping("/login")
    public String login() {
        /* TODO Implement html */
        return "LOGIN PAGE";
    }

    @GetMapping("/courses")
    public String courses() {
        /* TODO Implement html */
        return "COURSES PAGE";
    }

    @GetMapping("/course/{id}")
    public String course() {
        /* TODO Implement html */
        return "COURSES PAGE";
    }

    @GetMapping(value = "/course/{cid}/student/{sid}")
    public String student(@PathVariable String cid, @PathVariable String sid) {
        /* TODO Implement html */
        return "(COURSE,STUDENT) : (" + cid + "," + sid + ")";
    }
}
