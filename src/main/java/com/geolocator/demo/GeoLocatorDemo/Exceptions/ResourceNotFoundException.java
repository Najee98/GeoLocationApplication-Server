package com.geolocator.demo.GeoLocatorDemo.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public ResourceNotFoundException(String exceptionMessage, Throwable exceptionCause) {
        super(exceptionMessage, exceptionCause);
    }
}