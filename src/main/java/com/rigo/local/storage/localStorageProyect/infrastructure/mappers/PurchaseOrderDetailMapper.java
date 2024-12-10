package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;

import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.PurchaseOrderDetailResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.PurchaseOrderDetailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseOrderDetailMapper {

    PurchaseOrderDetailResponse toResponse(PurchaseOrderDetailEntity entity);
}
