package com.geolocator.demo.GeoLocatorDemo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocRequest implements Serializable {

    String country;

    String city;

    String street;

    String postalCode;

    public String getFormattedAddress() {
        return String.format("%s, %s, %s, %s", street, city, postalCode, country);
    }
}
