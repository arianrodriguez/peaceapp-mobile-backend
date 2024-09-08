package com.upc.pre.peaceapp.services;

import com.upc.pre.peaceapp.models.Location;
import com.upc.pre.peaceapp.repositories.LocationRepository;
import com.upc.pre.peaceapp.schemas.LocationSchema;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public Location saveLocation(LocationSchema location) {
        return repository.save(new Location(location.latitude(), location.longitude()));
    }
}
