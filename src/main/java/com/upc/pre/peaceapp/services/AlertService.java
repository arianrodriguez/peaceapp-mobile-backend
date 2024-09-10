package com.upc.pre.peaceapp.services;

import com.upc.pre.peaceapp.models.Alert;
import com.upc.pre.peaceapp.repositories.AlertRepository;
import com.upc.pre.peaceapp.schemas.AlertSchema;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    private final AlertRepository repository;

    public AlertService(AlertRepository repository) {
        this.repository = repository;
    }

    public Alert saveAlert(AlertSchema alert) {
        Alert newAlert = repository.save(new Alert(alert.location(), alert.type(), alert.description(), alert.user_id()));
        return newAlert;
    }

    public Alert findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Alert> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
