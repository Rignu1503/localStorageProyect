package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.SuppliersRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.SupplierResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.CreateService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.DeleteService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.ReadAllService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.UpdateService;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;

public interface ISupplierService extends
        ReadAllService<SupplierResponse>,
        CreateService<SuppliersRequest, SupplierResponse>,
        UpdateService<SuppliersRequest, SupplierResponse, Long>,
        DeleteService<Long> {

    SupplierResponse getById(Long id) throws BadRequestException;
}
