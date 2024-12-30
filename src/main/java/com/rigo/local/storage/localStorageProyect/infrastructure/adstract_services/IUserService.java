package com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.UserRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.UserResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.CreateService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.DeleteService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.ReadAllService;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.generic.UpdateService;

public interface IUserService extends
        ReadAllService<UserResponse>,
        CreateService<UserRequest, UserResponse>,
        UpdateService<UserRequest, UserResponse, Long>,
        DeleteService<Long>
{


}
