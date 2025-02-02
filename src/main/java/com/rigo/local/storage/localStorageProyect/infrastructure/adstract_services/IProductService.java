package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ProductRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.ProductRelationResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.CreateService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.DeleteService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.ReadAllService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.UpdateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IProductService extends
        ReadAllService<ProductRelationResponse>,
        CreateService<ProductRequest, ProductRelationResponse>,
        UpdateService<ProductRequest, ProductRelationResponse, Long>,
        DeleteService<Long> {

    Page<ProductRelationResponse> getProductsByCategoryName(String categoryName, Pageable pageable);

    Optional<ProductRelationResponse> getProductName(String name, Pageable pageable);
}
