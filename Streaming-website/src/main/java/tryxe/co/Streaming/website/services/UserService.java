package tryxe.co.Streaming.website.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tryxe.co.Streaming.website.entities.User;
import tryxe.co.Streaming.website.repositories.UserRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User create(User user) {
        user.setRegistrationDate(LocalDate.now());
        return userRepository.saveAndFlush(user);
    }

    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }
}
