package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.PurchaseOrderRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.request.Update.PurchaseOrderRequestUpdate;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.PurchaseOrderRelationResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.CreateService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.ReadAllService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.UpdateService;

public interface IPurchaseOrderService extends
        ReadAllService<PurchaseOrderRelationResponse>,
        CreateService<PurchaseOrderRequest, PurchaseOrderRelationResponse>,
        UpdateService<PurchaseOrderRequestUpdate, PurchaseOrderRelationResponse, Long> {
}
