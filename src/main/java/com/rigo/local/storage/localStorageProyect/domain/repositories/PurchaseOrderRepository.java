package com.rigo.local.storage.localStorageProyect.domain.repositories;

import com.rigo.local.storage.localStorageProyect.domain.entities.PurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderEntity, Long> {
}
