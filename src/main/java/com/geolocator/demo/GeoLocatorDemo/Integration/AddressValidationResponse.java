package com.geolocator.demo.GeoLocatorDemo.Integration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressValidationResponse {
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private Double lon;
    private Double lat;
//    private Geometry geometry;
//
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class Geometry {
//        private Location location;
//
//        @Data
//        @AllArgsConstructor
//        @NoArgsConstructor
//        public static class Location {
//
//        }
//    }
}
