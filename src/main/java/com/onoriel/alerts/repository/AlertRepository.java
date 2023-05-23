package com.onoriel.alerts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onoriel.alerts.model.Alert;

public interface AlertRepository extends MongoRepository<Alert, String> {
    // Additional custom methods can be added here if needed
}
