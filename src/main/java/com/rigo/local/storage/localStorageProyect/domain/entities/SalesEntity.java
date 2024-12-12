package com.rigo.local.storage.localStorageProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "sales")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();

    @Column(nullable = false)
    private double total;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = false)
    private List<SalesDetailEntity> salesDetailList;


}
