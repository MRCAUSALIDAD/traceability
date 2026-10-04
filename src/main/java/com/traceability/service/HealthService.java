package com.traceability.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.traceability.dto.HealthDto;
import com.traceability.enums.Health;
// @Service normalmente crea un singleton, un Singleton en esencia es una clase de la que existe una única instancia compartida dentro de la aplicación
@Service
public class HealthService {

    private final RestClient restClient = RestClient.create(); //validar peticiones HTTP

    public HealthDto stateHealth() {
        try {
            ResponseEntity<Void> response = restClient
            .get()
            .uri("https://www.google.com")
            .retrieve()
            .toBodilessEntity();

        if (response.getStatusCode().is2xxSuccessful()) {
            return new HealthDto(Health.UP);
        }

        return new HealthDto(Health.DOWN);
        } catch (Exception e) {
            return new HealthDto(Health.DOWN);
        }
    //    Health health = "OK".equals(status) ? Health.UP : Health.DOWN;
    //    return new HealthDto(health);
    }
}
