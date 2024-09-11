package com.upc.pre.peaceapp.controllers;

import com.upc.pre.peaceapp.models.Alert;
import com.upc.pre.peaceapp.schemas.AlertSchema;
import com.upc.pre.peaceapp.services.AlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/alerts")
@Tag(name = "Alerts", description = "Alerts Endpoints")
public class AlertController {
    private final AlertService service;

    public AlertController(AlertService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<?> newAlert(@RequestBody AlertSchema alert) {
        try {
            Alert newAlert = service.saveAlert(alert);
            return ResponseEntity.created(null).body(newAlert);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlertById(@PathVariable Long id) {
        try {
            Alert alert = service.findById(id);
            if (alert == null) {
                return ResponseEntity.badRequest().body(Map.of("message", "Alert not found"));
            }
            return ResponseEntity.ok(alert);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAlertsByUserId(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(service.findByUserId(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }
}
