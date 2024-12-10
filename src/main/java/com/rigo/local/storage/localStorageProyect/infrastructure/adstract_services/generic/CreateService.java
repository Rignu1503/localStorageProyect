package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic;

import org.apache.coyote.BadRequestException;

public interface CreateService<Request, Response> {
    Response create(Request request) throws BadRequestException;
}
