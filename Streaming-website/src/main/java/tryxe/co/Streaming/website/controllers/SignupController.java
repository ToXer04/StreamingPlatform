package tryxe.co.Streaming.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tryxe.co.Streaming.website.entities.User;
import tryxe.co.Streaming.website.services.UserService;

@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    public User create(@ModelAttribute User user) {


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.create(user);
    }
}
