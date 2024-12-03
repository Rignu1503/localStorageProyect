package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.CategoryRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.CategoryResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.CreateService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.DeleteService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.ReadAllService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.UpdateService;

public interface IcategoryService extends
        ReadAllService<CategoryResponse>,
        CreateService<CategoryRequest, CategoryResponse>,
        UpdateService<CategoryRequest, CategoryResponse, Long >,
        DeleteService< Long>{

}
