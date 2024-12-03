package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic;

import org.apache.coyote.BadRequestException;

public interface DeleteService <Id>{

    void delete(Id id) throws BadRequestException;
}
