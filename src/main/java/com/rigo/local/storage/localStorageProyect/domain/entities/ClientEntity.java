package com.rigo.local.storage.localStorageProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "clients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 20)
    private Long phone;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = false)
    private List<SalesEntity> saleList;
}
