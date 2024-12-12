package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;

import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.SalesDetailResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.SalesDetailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalesDetailMapper {

    SalesDetailResponse toResponse(SalesDetailEntity entity);
}
