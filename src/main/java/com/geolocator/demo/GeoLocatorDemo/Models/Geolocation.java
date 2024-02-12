package com.geolocator.demo.GeoLocatorDemo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "geolocation_coordinate")
//@AllArgsConstructor
@NoArgsConstructor
@Data
public class Geolocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geolocation_id")
    Long geolocationId;

    @Column(name = "longitude")
    Double longitude;

    @Column(name = "latitude")
    Double latitude;

    public Geolocation(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
