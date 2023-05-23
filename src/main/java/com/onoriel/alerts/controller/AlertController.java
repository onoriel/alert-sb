package com.onoriel.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onoriel.alerts.model.Alert;
import com.onoriel.alerts.repository.AlertRepository;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    
    private final AlertRepository alertRepository;

    @Autowired
    public AlertController(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @GetMapping
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    @PostMapping
    public Alert createAlert(@RequestBody Alert alert) {
        return alertRepository.save(alert);
    }

    @GetMapping("/{id}")
    public Alert getAlertById(@PathVariable("id") String id) {
        return alertRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Alert updateAlert(@PathVariable("id") String id, @RequestBody Alert updatedAlert) {
        updatedAlert.setId(id);
        return alertRepository.save(updatedAlert);
    }

    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable("id") String id) {
        alertRepository.deleteById(id);
    }
}
