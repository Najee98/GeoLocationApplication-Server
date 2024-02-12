//package com.geolocator.demo.GeoLocatorDemo.Email;
//
//import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocRequest;
//import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocResponse;
//import com.geolocator.demo.GeoLocatorDemo.Services.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.SimpleMailMessage;
//
//public class SimpleMessageTemplate {
//
//    private final AddressService addressService;
//
//    @Autowired
//    public SimpleMessageTemplate(AddressService addressService) {
//        this.addressService = addressService;
//    }
//
//    @Bean
//    public SimpleMailMessage messageTemplate(){
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        GeoLocResponse mailTemplateResponse = addressService.getAddressGeoLocation();
//        message.setText(
//                "Geolocation coordinates: \nlongitude: %s,\nlatitude: %s", );
//        return message;
//    }
//}
