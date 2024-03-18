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
    public User create(@ModelAttribute User user) {
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

//    @PutMapping("/update/{id}")
//    public User update(
//            @PathVariable Long id,
//            @RequestBody User user
//    ) {
//        return userService.update(id, user);
//    }
//
//    @PatchMapping("/update/{id}/name")
//    public User updateName(
//            @PathVariable Long id,
//            @RequestParam String value
//    ) throws Exception {
//        return userService.updateName(id, value);
//    }
//
//    @PatchMapping("/update/{id}/surname")
//    public User updateSurname(
//            @PathVariable Long id,
//            @RequestParam String value
//    ) throws Exception {
//        return userService.updateSurname(id, value);
//    }
//
//    @PatchMapping("/update/{id}/email")
//    public User updateEmail(
//            @PathVariable Long id,
//            @RequestParam String value
//    ) throws Exception {
//        return userService.updateEmail(id, value);
//    }
//
//    @PatchMapping("/update/{id}/birth-date")
//    public User updateBirthDate(
//            @PathVariable Long id,
//            @RequestParam String value
//    ) throws Exception {
//        return userService.updateBirthDate(id, value);
//    }
//
//    @PatchMapping("/update/{id}/country")
//    public User updateCountry(
//            @PathVariable Long id,
//            @RequestParam String value
//    ) throws Exception {
//        return userService.updateCountry(id, value);
//    }
//
//    @PatchMapping("/update/{id}/prefix")
//    public User updatePrefix(
//            @PathVariable Long id,
//            @RequestParam String value
//    ) throws Exception {
//        return userService.updatePrefix(id, value);
//    }
//
//    @PatchMapping("/update/{id}/phone-number")
//    public User updatePhoneNumber(
//            @PathVariable Long id,
//            @RequestParam String value
//    ) throws Exception {
//        return userService.updatePhoneNumber(id, value);
//    }
//    @PatchMapping("/update/{id}/{roleId}")
//    public User updateRole(
//            @PathVariable Long id,
//            @PathVariable Long roleId
//    ) throws Exception {
//        return userService.updateRole(id, roleId);
//    }

    //TODO
//    @PatchMapping("/update/{id}/membership")
//    public User updateMembership(
//            @PathVariable Long id,
//            @RequestParam String value
//    ) throws Exception {
//        return userService.updateMembership(id, value);
//    }
    @DeleteMapping("/delete/{id}")
    public void delete(
            @PathVariable Long id
    ) throws Exception {
        userService.delete(id);
    }
}
