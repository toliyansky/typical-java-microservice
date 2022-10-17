package dev.toliyansky.microservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Client")
public class ClientEntity {
    @Id
    private UUID uuid;
    @Column(name = "`name`")
    private String name;
    @Column(name = "`accountsLimit`")
    private Integer accountsLimit;
    @Column(name = "`banned`")
    private Boolean banned;
    @Column(name = "`createdAt`")
    private Instant createdAt;
}
