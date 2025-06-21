package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import java.util.Map;

@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public void register(@Valid User user) {
        // Additional business logic validation
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ValidationException(Map.of("email", "Email already exists"));
        }

        userRepository.save(user);
        emailService.sendRegistrationEmail(user);
    }
}