package com.geolocator.demo.GeoLocatorDemo.Integration.Utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties {
    Map<String, Object> datasource;
    String name;
    String country;
    String country_code;
    String state;
    String county;
    String city;
    Double lon;
    Double lat;
    String result_type;
    String formatted;
    String address_line1;
    String address_line2;
    String category;
    Map<String, Object> timezone;
    String plus_code;
    String plus_code_short;
    Map<String, Object> rank;
    String place_id;

}