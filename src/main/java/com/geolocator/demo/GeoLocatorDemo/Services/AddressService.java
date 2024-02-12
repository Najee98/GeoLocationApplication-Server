package com.geolocator.demo.GeoLocatorDemo.Services;

import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocRequest;
import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocResponse;

public interface AddressService {

    GeoLocResponse getAddressGeoLocation(GeoLocRequest request);
}
