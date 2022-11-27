package com.sero76.monitoringbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServerStatus {
    ONLINE("ONLINE"),
    OFFLINE("OFFLINE");

    private final String value;
}
