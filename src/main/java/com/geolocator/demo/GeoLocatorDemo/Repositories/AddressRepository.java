package com.geolocator.demo.GeoLocatorDemo.Repositories;

import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocResponse;
import com.geolocator.demo.GeoLocatorDemo.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select new com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocResponse(" +
            "gl.longitude," +
            "gl.latitude) " +
            "from " +
            "Address as addr join addr.geolocation as gl " +
            "where " +
            "(:country is null or addr.country = :country) and " +
            "(:city is null or addr.city = :city) and " +
            "(:street is null or addr.street = :street) and " +
            "(:postalCode is null or addr.postalCode = :postalCode)")
    Optional<GeoLocResponse> getAddress(@Param("country") String country,
                                        @Param("city") String city,
                                        @Param("street") String street,
                                        @Param("postalCode") String postalCode);

    Boolean existsByCountryAndCityAndStreetAndPostalCode(String country, String city, String street, String postalCode);
}
