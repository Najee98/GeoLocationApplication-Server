package com.geolocator.demo.GeoLocatorDemo.Services;

import com.geolocator.demo.GeoLocatorDemo.Repositories.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeolocationServiceImplementation implements GeolocationService {

    private final GeolocationRepository geolocationRepository;

    @Autowired
    public GeolocationServiceImplementation(GeolocationRepository geolocationCoordinateRepository) {
        this.geolocationRepository = geolocationCoordinateRepository;
    }

}
