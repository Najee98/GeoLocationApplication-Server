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
            "addr.country," +
            "addr.city," +
            "addr.street," +
            "addr.postalCode," +
            "gl.longitude," +
            "gl.latitude) " +
            "from " +
            "Address addr join Geolocation gl " +
            "on addr.geolocation.geolocationId = gl.geolocationId " +
            "where " +
            "(addr.country is null or addr.country = :country) and " +
            "(addr.city is null or addr.city = :city) and " +
            "(addr.street is null or addr.street = :street) and " +
            "(addr.postalCode is null or addr.postalCode = :postalCode)")
    Optional<GeoLocResponse> getAddress(@Param("country") String country,
                                        @Param("city") String city,
                                        @Param("street") String street,
                                        @Param("postalCode") String postalCode);
}
