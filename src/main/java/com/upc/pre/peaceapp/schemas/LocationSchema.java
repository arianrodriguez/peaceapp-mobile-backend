package com.upc.pre.peaceapp.schemas;

public record LocationSchema(String latitude, String longitude) {
    public LocationSchema {
        if (latitude == null || latitude.isBlank()) {
            throw new IllegalArgumentException("Latitude cannot be null or empty");
        }
        if (longitude == null || longitude.isBlank()) {
            throw new IllegalArgumentException("Longitude cannot be null or empty");
        }
    }
}
