package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@Service
@Validated
public class UserService {

    @Autowired
    private EmailService emailService;

    public void register(@Valid User user) {
        // No DB check or save, just send email
        emailService.sendRegistrationEmail(user);
    }
}