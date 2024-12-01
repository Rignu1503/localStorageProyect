package com.rigo.local.storage.localStorageProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column( length = 50)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, unique = true, length = 50)
    private String barcode;

    @Column(nullable = false)
    private int stockCurrent;

    @Column(nullable = false)
    private int stockMinimun;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<PurchaseOrderDetailEntity> purchaseOrderDetailList;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<SalesDetailEntity> salesDetailList;
}
