package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic;

import java.util.Optional;

public interface ReadByIdService<Response, Id> {
    Optional<Response> getById(Id id);
}