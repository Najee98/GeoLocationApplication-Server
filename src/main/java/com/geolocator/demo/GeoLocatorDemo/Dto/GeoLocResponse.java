package com.geolocator.demo.GeoLocatorDemo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GeoLocResponse {

    Double longitude;

    Double latitude;

    public GeoLocResponse() {
    }

    public GeoLocResponse(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
