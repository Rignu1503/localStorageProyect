package com.rigo.local.storage.localStorageProyect.domain.repositories;

import com.rigo.local.storage.localStorageProyect.domain.entities.SalesDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDetailRepository extends JpaRepository<SalesDetailEntity, Long> {
}
