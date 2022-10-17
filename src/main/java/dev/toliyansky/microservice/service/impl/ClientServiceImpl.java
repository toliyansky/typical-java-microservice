package dev.toliyansky.microservice.service.impl;

import dev.toliyansky.microservice.converter.ClientConverter;
import dev.toliyansky.microservice.entity.ClientEntity;
import dev.toliyansky.microservice.repository.ClientRepository;
import dev.toliyansky.microservice.service.ClientService;
import dev.toliyansky.openapi.model.Client;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;

    @Override
    public Client getByUuid(UUID uuid) {
        var clientEntity = clientRepository.getByUuid(uuid);
        if (clientEntity == null) {
            log.debug("Client with uuid {} not found in database", uuid);
            throw new EntityNotFoundException("Client not found");
        }
        return clientConverter.convert(clientEntity);
    }

    @Override
    public Client registerClient(Client client) {
        var clientEntity = ClientEntity.builder()
                .uuid(UUID.randomUUID())
                .name(client.getName())
                .accountsLimit(client.getAccountsLimit())
                .banned(false)
                .createdAt(Instant.now())
                .build();
        clientEntity = clientRepository.saveAndFlush(clientEntity);
        return clientConverter.convert(clientEntity);
    }
}
