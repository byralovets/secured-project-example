package by.ralovets.students.service;

import by.ralovets.students.Role;
import by.ralovets.students.entity.User;
import by.ralovets.students.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void createUser(String username, String password) {
        final String passwordHash = passwordEncoder.encode(password);

        final User user = new User();

        user.setUsername(username);
        user.setPassword(passwordHash);
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);
    }

    public User getCurrentUser() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> optionalUser = userRepository.findByUsername(username);

        // if empty

        return optionalUser.get();
    }
}
