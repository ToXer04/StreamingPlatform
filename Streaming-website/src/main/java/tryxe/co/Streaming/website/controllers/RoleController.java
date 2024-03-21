package tryxe.co.Streaming.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tryxe.co.Streaming.website.entities.Role;
import tryxe.co.Streaming.website.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public Role create(
            @RequestBody Role role
    ) {
        return roleService.create(role);
    }
}
