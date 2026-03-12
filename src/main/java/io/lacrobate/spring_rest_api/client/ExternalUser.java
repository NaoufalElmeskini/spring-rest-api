package io.lacrobate.spring_rest_api.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalUser(int id, String name, String email) {}
