package com.geolocator.demo.GeoLocatorDemo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GeoLocResponse {

    String country;

    String city;

    String street;

    String postalCode;

    Double longitude;

    Double latitude;

    public GeoLocResponse() {
    }

    public GeoLocResponse(String country, String city, String street, String postalCode, Double longitude, Double latitude) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
