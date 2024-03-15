package tryxe.co.Streaming.website.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tryxe.co.Streaming.website.entities.User;
import tryxe.co.Streaming.website.repositories.UserRepository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        user.setRegistrationDate(userRepository.findById(id).get().getRegistrationDate());
        user.setId(id);
        return userRepository.save(user);
    }

    public User updateName(Long id, String name) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        user.get().setName(name);
        return userRepository.save(user.get());
    }

    public User updateSurname(Long id, String surname) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        user.get().setSurname(surname);
        return userRepository.save(user.get());
    }

    public User updateEmail(Long id, String email) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        try {
            user.get().setEmail(email);
            return userRepository.save(user.get());
        } catch (Exception e) {
            throw new Exception("The email " + email + " is already associated to an account");
        }
    }

    public User updateBirthDate(Long id, String birthDate) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        try {
            user.get().setBirthDate(LocalDate.parse(birthDate));
            return userRepository.save(user.get());
        } catch (Exception exception) {
            throw new Exception("Wrong format, it must be yyyy-mm-dd");
        }
    }

    public User updateCountry(Long id, String country) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        user.get().setCountry(country);
        return userRepository.save(user.get());
    }

    public User updatePrefix(Long id, String prefix) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        try {
            user.get().setPrefix(Long.parseLong(prefix));
            return userRepository.save(user.get());
        } catch (Exception exception) {
            throw new Exception("Wrong format, it must be a numeric value");
        }
    }

    public User updatePhoneNumber(Long id, String phoneNumber) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        try {
            if (phoneNumber.length() < 7 || phoneNumber.length() > 15) throw new NumberFormatException();
            user.get().setPhoneNumber(BigInteger.valueOf(Long.parseLong((phoneNumber))));
            return userRepository.save(user.get());
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Wrong format, it must be a numeric value between 7 and 15 digits");
        } catch (Exception e) {
            throw new Exception("The phone number " + phoneNumber + " is already associated to an account");
        }
    }

    //TODO
//    public User updateMembership(Long id, String membershipId) throws Exception {
//        Optional<User> user = userRepository.findById(id);
//        if(user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
//        return null;
//    }
    public void delete(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new Exception("User with id " + id + " doesn't exist");
        userRepository.delete(user.get());
    }
}
