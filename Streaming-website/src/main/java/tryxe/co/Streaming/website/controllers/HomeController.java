package tryxe.co.Streaming.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homeController() {
        return "index.html";
    }
    @GetMapping("/login")
    public String loginController() {
        return "form.html";
    }
}
