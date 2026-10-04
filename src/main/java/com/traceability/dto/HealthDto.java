package com.traceability.dto;

import com.traceability.enums.Health;

// con record nos ahorramos: constructor, getter, setter y campo manualmente.
public record HealthDto(Health status) {}
