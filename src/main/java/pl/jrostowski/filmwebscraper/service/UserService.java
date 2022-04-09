package pl.jrostowski.filmwebscraper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jrostowski.filmwebscraper.entity.User;
import pl.jrostowski.filmwebscraper.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    public List<User> findAllByOrderByIdAsc() {
        return userRepository.findAllByOrderByUserIdAsc();
    }

    public User findByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }

}
