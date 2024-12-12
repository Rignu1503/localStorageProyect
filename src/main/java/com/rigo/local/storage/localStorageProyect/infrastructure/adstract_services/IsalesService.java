package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.SalesRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.SalesRelationResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.CreateService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.ReadAllService;



public interface IsalesService extends
        ReadAllService<SalesRelationResponse>,
        CreateService<SalesRequest, SalesRelationResponse>
        {
}
