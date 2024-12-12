package com.rigo.local.storage.localStorageProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "sale_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double UnitPrice;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private SalesEntity sale;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
}
