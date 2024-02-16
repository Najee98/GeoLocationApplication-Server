package com.geolocator.demo.GeoLocatorDemo.Integration;

import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocRequest;
import com.geolocator.demo.GeoLocatorDemo.Dto.GeoLocResponse;
import com.geolocator.demo.GeoLocatorDemo.Integration.Utilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AddressValidationService {

    private final RestTemplate restTemplate;
    private final String geoapifyApiUrl = "https://api.geoapify.com/v1/geocode/search";
    private final String apiKey = "1c6c587b77574027ab307e14cd514c8f";

    @Autowired
    public AddressValidationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Optional<GeoLocResponse> validateAddress(GeoLocRequest address) {
        String url = String.format("%s?apiKey=%s&country=%s&city=%s&street=%s&postalCode=%s",
                geoapifyApiUrl, apiKey, address.getCountry(), address.getCity(), address.getStreet(), address.getPostCode());
        AddressValidationResponse apiResponse = this.restTemplate.getForObject(url, AddressValidationResponse.class);

        if (apiResponse.getFeatures().isEmpty()) {
            return Optional.empty();
        }

        Feature feature = apiResponse.getFeatures().get(0);

        GeoLocResponse response = new GeoLocResponse();
        response.setLongitude(feature.getProperties().getLon());
        response.setLatitude(feature.getProperties().getLat());

        return Optional.of(response);
    }

}
