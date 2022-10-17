package dev.toliyansky.microservice.controller;

import dev.toliyansky.microservice.service.ClientService;
import dev.toliyansky.openapi.api.ClientApiController;
import dev.toliyansky.openapi.model.Client;
import dev.toliyansky.openapi.model.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class ClientController extends ClientApiController {

    private final ClientService clientService;

    public ClientController(NativeWebRequest request, ClientService clientService) {
        super(request);
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<ClientResponse> clientGet(UUID id) {
        var clientResponse = new ClientResponse();
        try {
            var clientDto = clientService.getByUuid(id);
            clientResponse.setSuccess(true);
            clientResponse.setClient(clientDto);
            return ResponseEntity.ok(clientResponse);
        } catch (Exception e) {
            log.error("Error while get client", e);
            clientResponse.setSuccess(false);
            clientResponse.setMessage(e.getMessage());
            clientResponse.setClient(null);
            return ResponseEntity.internalServerError().body(clientResponse);
        }
    }

    @Override
    public ResponseEntity<ClientResponse> clientPost(Client client) {
        var clientResponse = new ClientResponse();
        try {
            var clientDto = clientService.registerClient(client);
            clientResponse.setSuccess(true);
            clientResponse.setClient(clientDto);
            return ResponseEntity.ok(clientResponse);
        } catch (Exception e) {
            log.error("Error while register client", e);
            clientResponse.setSuccess(false);
            clientResponse.setMessage(e.getMessage());
            clientResponse.setClient(null);
            return ResponseEntity.internalServerError().body(clientResponse);
        }
    }
}
