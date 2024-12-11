package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ClientRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ClientResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.CreateService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.DeleteService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.ReadAllService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.UpdateService;

public interface IClientService extends
        ReadAllService<ClientResponse>,
        CreateService<ClientRequest, ClientResponse>,
        UpdateService<ClientRequest, ClientResponse, Long>,
        DeleteService<Long> {
}
