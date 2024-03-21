package tryxe.co.Streaming.website.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import tryxe.co.Streaming.website.entities.Role;
import tryxe.co.Streaming.website.repositories.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role create(Role role) {
        return roleRepository.saveAndFlush(role);
    }
}
