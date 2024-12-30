package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.UserRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.UserResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserRequest request);

    UserResponse toResponse(UserEntity entity);

    void update(UserRequest request, @MappingTarget UserEntity entity);
}
