package com.geolocator.demo.GeoLocatorDemo.Integration.Utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Parsed {
    private String city;
    private String country;
    private String expected_type;
}