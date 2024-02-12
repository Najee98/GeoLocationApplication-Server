package com.geolocator.demo.GeoLocatorDemo.Repositories;

import com.geolocator.demo.GeoLocatorDemo.Models.Geolocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocationRepository extends JpaRepository<Geolocation, Long> {


}
