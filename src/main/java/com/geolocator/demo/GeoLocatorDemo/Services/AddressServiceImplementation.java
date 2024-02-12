package com.geolocator.demo.GeoLocatorDemo.Services;

import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocRequest;
import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocResponse;
import com.geolocator.demo.GeoLocatorDemo.Exceptions.CustomExceptions.ResourceNotFoundException;
import com.geolocator.demo.GeoLocatorDemo.Integration.AddressValidationService;
import com.geolocator.demo.GeoLocatorDemo.Models.Address;
import com.geolocator.demo.GeoLocatorDemo.Models.Geolocation;
import com.geolocator.demo.GeoLocatorDemo.Repositories.AddressRepository;
import com.geolocator.demo.GeoLocatorDemo.Repositories.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImplementation implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressValidationService addressValidationService;
    private final GeolocationRepository geolocationRepository;

    @Autowired
    public AddressServiceImplementation(AddressRepository addressRepository, AddressValidationService addressValidationService, GeolocationRepository geolocationCoordinateRepository) {
        this.addressRepository = addressRepository;
        this.addressValidationService = addressValidationService;
        this.geolocationRepository = geolocationCoordinateRepository;
    }

    @Override
    public GeoLocResponse getAddressGeoLocation(GeoLocRequest request) {

        Optional<GeoLocResponse> response = null;

        Boolean responseExistsInLocalDB = addressRepository.existsByCountryAndCityAndStreetAndPostalCode(
                request.getCountry(),
                request.getCity(),
                request.getStreet(),
                request.getPostalCode());

        try {
            //If the address is present in the database, the response is sent to the client directly. No need for external API
            if(responseExistsInLocalDB){
                 response = addressRepository.getAddress(
                        request.getCountry(),
                        request.getCity(),
                        request.getStreet(),
                        request.getPostalCode());
            }else{
                //fetch the address from the external API with validation.
                response = Optional.ofNullable(addressValidationService.validateAddress(request))
                        .orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist."));

                //insert the new data in the corresponding tables before returning the response
                Geolocation geolocation = new Geolocation(
                        response.get().getLongitude(),
                        response.get().getLatitude()
                );

                geolocationRepository.save(geolocation);

                Address addressToInsert = new Address(
                        response.get().getCountry(),
                        response.get().getCity(),
                        response.get().getStreet(),
                        response.get().getPostalCode(),
                        geolocation);

                addressRepository.save(addressToInsert);
            }

            return response.get();

        } catch (Exception e) {
            throw e;
        }
    }
}
