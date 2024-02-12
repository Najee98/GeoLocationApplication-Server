package com.geolocator.demo.GeoLocatorDemo.Email;

import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocResponse;
import com.geolocator.demo.GeoLocatorDemo.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
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

    public void sendMessage(String sendTo, GeoLocResponse geolocation) throws MailSendException {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("test@test-domain.com");
        message.setTo(sendTo);
        message.setSubject("Geolocation Email Subject");

        String msgContent = String.format("Geolocation: \nLongitude: %f \nLatitude: %f", geolocation.getLongitude(), geolocation.getLatitude());
        message.setText(msgContent);

        emailSender.send(message);
    }


}
