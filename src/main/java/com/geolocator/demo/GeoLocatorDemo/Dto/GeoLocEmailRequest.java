package com.geolocator.demo.GeoLocatorDemo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocEmailRequest implements Serializable {

    String mailReceiver;

    GeoLocResponse geolocationResult;

}
