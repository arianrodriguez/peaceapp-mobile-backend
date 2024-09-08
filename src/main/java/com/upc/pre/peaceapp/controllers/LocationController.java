package com.upc.pre.peaceapp.controllers;

import com.upc.pre.peaceapp.schemas.LocationSchema;
import com.upc.pre.peaceapp.services.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/locations")
@Tag(name = "Location", description = "Location Endpoints")
public class LocationController {
    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveNewLocation(@RequestBody LocationSchema location) {
        try{
            return ResponseEntity.created(null).body(service.saveLocation(location));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }
}
