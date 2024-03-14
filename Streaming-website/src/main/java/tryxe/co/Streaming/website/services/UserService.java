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
    public List<User> getAll() {
        return userRepository.findAll();
    }
    public User update(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }
    public User updateName(Long id, String name) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        user.get().setName(name);
        return userRepository.save(user.get());
    }
    public User updateSurname(Long id, String surname) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        user.get().setSurname(surname);
        return userRepository.save(user.get());
    }
}
