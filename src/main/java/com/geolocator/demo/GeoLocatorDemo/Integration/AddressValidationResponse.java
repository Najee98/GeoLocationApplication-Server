package com.geolocator.demo.GeoLocatorDemo.Integration;

import com.geolocator.demo.GeoLocatorDemo.Integration.Utilities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressValidationResponse {
    String type;
    List<Feature> features;
    Query query;
}
