package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.PurchaseOrderRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.request.Update.PurchaseOrderRequestUpdate;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.PurchaseOrderRelationResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.PurchaseOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring", uses = {SupplierMapper.class, PurchaseOrderDetailMapper.class})
public interface PurchaseOrderMapper {


    PurchaseOrderEntity toEntity(PurchaseOrderRequest request);

    @Mapping(target = "orderDetail", source = "purchaseOrderDetailList")
    PurchaseOrderRelationResponse toResponse(PurchaseOrderEntity entity);

    void updatePurchaseOrder(PurchaseOrderRequestUpdate request, @MappingTarget PurchaseOrderEntity entity);
}

