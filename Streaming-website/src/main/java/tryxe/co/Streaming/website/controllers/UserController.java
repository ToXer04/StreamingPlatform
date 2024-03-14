package tryxe.co.Streaming.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tryxe.co.Streaming.website.entities.User;
import tryxe.co.Streaming.website.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public User create(
            @RequestBody User user
    ) {
        return userService.create(user);
    }
    @GetMapping("/get/{id}")
    public Optional<User> get(
            @PathVariable Long id
    ) {
        return userService.get(id);
    }
    @GetMapping("/get-all")
    public List<User> getAll() {
        return userService.getAll();
    }
    @PutMapping("/update/{id}")
    public User update(
            @PathVariable Long id,
            @RequestBody User user
    ) {
        return userService.update(id, user);
    }
    @PatchMapping("/update/{id}/name")
    public User updateName(
            @PathVariable Long id,
            @RequestParam String value
    ) throws Exception {
        return userService.updateName(id, value);
    }
}
