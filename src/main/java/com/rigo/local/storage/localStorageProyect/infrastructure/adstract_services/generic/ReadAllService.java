package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface  ReadAllService<Response> {
    Page<Response> getAll(Pageable pageable);
}
