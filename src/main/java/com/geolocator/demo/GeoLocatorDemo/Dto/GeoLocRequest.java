package com.geolocator.demo.GeoLocatorDemo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocRequest implements Serializable {

    String country; // This should be the country code

    String city; // This should be the city

    String street; // This should be the street address

    String postalCode;

    public String getFormattedAddress() {
        return String.format("%s, %s, %s, %s", street, city, postalCode, country);
    }
}
