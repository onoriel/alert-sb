package com.onoriel.alerts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "alerts")
public class Alert {

    @Id
    private String id;
    private String name;
    private String type;
    private String message;
    
}
