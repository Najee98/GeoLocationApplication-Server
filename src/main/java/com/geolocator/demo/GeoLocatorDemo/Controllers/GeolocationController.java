package com.geolocator.demo.GeoLocatorDemo.Controllers;

import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocRequest;
import com.geolocator.demo.GeoLocatorDemo.Email.EmailService;
import com.geolocator.demo.GeoLocatorDemo.Exceptions.ResourceNotFoundException;
import com.geolocator.demo.GeoLocatorDemo.Services.AddressService;
import com.geolocator.demo.GeoLocatorDemo.Services.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geolocation")
public class GeolocationController {

    private final AddressService addressService;
    private final GeolocationService geolocationCoordinateService;
    private final EmailService emailService;

    @Autowired
    public GeolocationController(AddressService addressService, GeolocationService geolocationCoordinateService, EmailService emailService) {
        this.addressService = addressService;
        this.geolocationCoordinateService = geolocationCoordinateService;
        this.emailService = emailService;
    }

    @PostMapping("/get")
    public ResponseEntity<Object> getGeolocation(@RequestBody GeoLocRequest request){
        try{
            return new ResponseEntity<>(addressService.getAddressGeoLocation(request), HttpStatus.OK);
        }catch(ResourceNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/send-mail")
    public ResponseEntity<Object> sendEmail(@RequestParam String mailReceiver){
        try{
            emailService.sendMessage(mailReceiver);
            return new ResponseEntity<>("{ \"message\": \"email send successfully.\" }", HttpStatus.OK);
        }catch (MailSendException e){
            //returning a 501 error to demonstrate request fail
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
