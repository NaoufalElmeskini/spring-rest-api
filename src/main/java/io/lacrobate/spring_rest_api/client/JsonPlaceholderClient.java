package io.lacrobate.spring_rest_api.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class JsonPlaceholderClient {
    private final RestClient restClient;

    public JsonPlaceholderClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<ExternalUser> getUsers() {
        return restClient.get()
            .uri("/users")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {});
    }
}
