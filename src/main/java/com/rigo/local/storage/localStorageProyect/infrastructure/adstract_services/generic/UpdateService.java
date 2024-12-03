package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic;

import org.apache.coyote.BadRequestException;

public interface UpdateService<Request, Response, Id> {
    Response update(Id id, Request request) throws BadRequestException;
}