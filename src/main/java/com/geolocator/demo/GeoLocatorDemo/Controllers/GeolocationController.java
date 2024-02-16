package com.geolocator.demo.GeoLocatorDemo.Controllers;

import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocEmailRequest;
import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocRequest;
import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocResponse;
import com.geolocator.demo.GeoLocatorDemo.Email.EmailService;
import com.geolocator.demo.GeoLocatorDemo.Exceptions.CustomExceptions.ResourceNotFoundException;
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
        return new ResponseEntity<>(addressService.getAddressGeoLocation(request), HttpStatus.OK);
    }

    @GetMapping("/send-mail")
    public ResponseEntity<Object> sendEmail(@RequestBody GeoLocEmailRequest request){
        emailService.sendMessage(request.getMailReceiver(), request.getGeolocationResult());
        String email = String
                .format("{ \"message\": \"email sent successfully with geolocation (%f, %f).\" }",
                        request.getGeolocationResult().getLongitude(),
                        request.getGeolocationResult().getLatitude());
        return new ResponseEntity<>(email, HttpStatus.OK);
    }
}
