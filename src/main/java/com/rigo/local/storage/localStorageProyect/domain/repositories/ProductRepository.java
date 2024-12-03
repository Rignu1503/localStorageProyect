package com.rigo.local.storage.localStorageProyect.domain.repositories;

import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.ProductRelationResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByName(String name);
    ProductEntity findByBarcode(String name);
    Page<ProductEntity> findByCategoryName(String categoryName, Pageable pageable);

}
