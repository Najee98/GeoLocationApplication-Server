package com.geolocator.demo.GeoLocatorDemo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
//@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    Long addressId;

    @Column(name = "country")
    String country;

    @Column(name = "city")
    String city;

    @Column(name = "street")
    String street;

    @Column(name = "postal_code")
    String postalCode;

    @OneToOne
    @JoinColumn(name = "geolocationId", referencedColumnName = "geolocation_id", nullable = true)
    Geolocation geolocation;

    public Address(String country, String city, String street, String postalCode, Geolocation geolocation) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.geolocation = geolocation;
    }
}
