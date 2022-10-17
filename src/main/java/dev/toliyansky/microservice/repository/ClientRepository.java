package dev.toliyansky.microservice.repository;

import dev.toliyansky.microservice.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    ClientEntity getByUuid(UUID uuid);
}
