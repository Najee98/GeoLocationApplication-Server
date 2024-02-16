package com.geolocator.demo.GeoLocatorDemo.Integration.Utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {
    String text;
    String city;
    String country;
    Parsed parsed;
}