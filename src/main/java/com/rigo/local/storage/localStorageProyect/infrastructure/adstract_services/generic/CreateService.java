package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic;

public interface CreateService<Request, Response> {
    Response create(Request request);
}
