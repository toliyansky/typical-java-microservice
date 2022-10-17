package dev.toliyansky.microservice.converter;

import dev.toliyansky.microservice.entity.ClientEntity;
import dev.toliyansky.openapi.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {
    public Client convert(ClientEntity clientEntity) {
        var clientDto = new Client();
        clientDto.setId(clientEntity.getUuid());
        clientDto.setName(clientEntity.getName());
        clientDto.setAccountsLimit(clientEntity.getAccountsLimit());
        clientDto.setBanned(clientEntity.getBanned());
        clientDto.setCreatedAt(clientEntity.getCreatedAt());
        return clientDto;
    }
}
