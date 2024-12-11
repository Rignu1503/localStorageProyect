package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ClientRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ClientResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    ClientEntity toEntity(ClientRequest request);

    ClientResponse toResponse(ClientEntity entity);

    void update(ClientRequest request, @MappingTarget ClientEntity entity);
}
