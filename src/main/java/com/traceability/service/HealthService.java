package com.traceability.service;

import org.springframework.stereotype.Service;

import com.traceability.dto.HealthDto;
import com.traceability.enums.Health;
// @Service normalmente crea un singleton, un Singleton en esencia es una clase de la que existe una única instancia compartida dentro de la aplicación
@Service
public class HealthService {

    public HealthDto stateHealth(String status) {
       Health health = "OK".equals(status) ? Health.UP : Health.DOWN;
       return new HealthDto(health);
    }
}
