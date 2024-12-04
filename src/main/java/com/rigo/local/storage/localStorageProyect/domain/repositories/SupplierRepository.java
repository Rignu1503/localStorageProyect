package com.rigo.local.storage.localStorageProyect.domain.repositories;

import com.rigo.local.storage.localStorageProyect.domain.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    SupplierEntity findByName(String name);
    SupplierEntity findByPhone(int phone);
    SupplierEntity findByAddress(String address);
    SupplierEntity findByEmail(String email);
}
