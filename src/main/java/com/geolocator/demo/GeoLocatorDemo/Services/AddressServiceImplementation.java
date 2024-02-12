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

        try {
            //If the address is present in the database, the response is sent to the client directly
            Optional<GeoLocResponse> response = addressRepository.getAddress(
                    request.getCountry(),
                    request.getCity(),
                    request.getStreet(),
                    request.getPostalCode());

            //fetch the geolocation from the third party API and store it in the database, and then return the response to the client
            if(response.isEmpty()){
                //fetch the address from the external API
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
                        response.get().getPostalCode());

                addressRepository.save(addressToInsert);
            }
            return response.get();

        } catch (Exception e) {
            throw e;
        }
    }
}
