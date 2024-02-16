package com.geolocator.demo.GeoLocatorDemo.Integration.Utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    String type;
    Properties properties;
    Geometry geometry;
    List<Double> bbox;
}
