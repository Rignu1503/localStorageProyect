package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ProductRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ProductResponse;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.ProductRelationResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.ProductEntity;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.CreateService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.DeleteService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.ReadAllService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.UpdateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IProductService extends
        ReadAllService<ProductRelationResponse>,
        CreateService<ProductRequest, ProductRelationResponse>,
        UpdateService<ProductRequest, ProductRelationResponse, Long>,
        DeleteService<Long> {

    Page<ProductRelationResponse> getProductsByCategoryName(String categoryName, Pageable pageable);
}
