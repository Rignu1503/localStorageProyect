package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.SuppliersRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.SupplierResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.SupplierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierEntity toEntity(SuppliersRequest request);

    SupplierResponse toResponse(SupplierEntity entity);

    void updateSupplier(SuppliersRequest request, @MappingTarget SupplierEntity entity);
}