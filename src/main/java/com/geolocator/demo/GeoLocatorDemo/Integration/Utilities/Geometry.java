package com.geolocator.demo.GeoLocatorDemo.Integration.Utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Geometry {
    private String type;
    private List<Double> coordinates;
}