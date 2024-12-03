package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.CategoryRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.CategoryResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    CategoryEntity toEntity(CategoryRequest categoryRequest);

    CategoryResponse toResponse(CategoryEntity categoryEntity);

    void updateCategory(CategoryRequest categoryRequest, @MappingTarget CategoryEntity categoryEntity);

}
