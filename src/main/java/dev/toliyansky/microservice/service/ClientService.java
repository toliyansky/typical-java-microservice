package dev.toliyansky.microservice.service;

import dev.toliyansky.openapi.model.Client;

import java.util.UUID;

public interface ClientService {
    Client getByUuid(UUID uuid);
    Client registerClient(Client client);
}
