package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;


import com.rigo.local.storage.localStorageProyect.api.dto.request.SalesRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.SalesRelationResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.SalesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, SalesDetailMapper.class})
public interface SalesMapper {

    SalesEntity toEntity(SalesRequest request);

    @Mapping(target = "salesDetails", source = "salesDetailList")
    SalesRelationResponse toResponse(SalesEntity entity);

    void updatePurchaseOrder(SalesRequest request, @MappingTarget SalesEntity entity);
}
