package com.traceability.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traceability.dto.HealthDto;
import com.traceability.service.HealthService;

// @RestController le dice a Spring que el valor que retorna cada método debe ir directamente al cuerpo (body) de la respuesta HTTP, 
// normalmente serializado como JSON
@RestController 
@RequestMapping("/api")
public class HealthController {
    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping(value = "/health")
    public HealthDto health() {
        return healthService.stateHealth("OK");
    }
}
