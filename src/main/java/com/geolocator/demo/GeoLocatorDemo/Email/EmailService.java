package com.geolocator.demo.GeoLocatorDemo.Email;

import com.geolocator.demo.GeoLocatorDemo.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMessage(String sendTo){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(sendTo);
        message.setSubject("Geolocation Email Subject");
        message.setText("Geolocation: ");

        emailSender.send(message);
    }


}
