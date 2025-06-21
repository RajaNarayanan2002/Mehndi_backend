package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${yourapp.notify.email}")
    private String notifyEmail;

    @Autowired
    private JavaMailSender mailSender;
@Async
public void sendRegistrationEmail(User user) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(notifyEmail);
    message.setSubject("New User Registration Notification");
    message.setText(
            "A new user has successfully registered with the following details:\n\n" +
                    "Name         : " + user.getName() + "\n" +
                    "Email        : " + user.getEmail() + "\n" +
                    "Mobile       : " + user.getMobile() + "\n" +
                    "Preference   : " + user.getPreference() + "\n\n" +
                    "Please take the necessary follow-up actions."
    );
    mailSender.send(message);
}

}