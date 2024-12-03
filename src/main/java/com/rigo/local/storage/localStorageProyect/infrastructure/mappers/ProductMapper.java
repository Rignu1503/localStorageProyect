package com.rigo.local.storage.localStorageProyect.infrastructure.mappers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ProductRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.ProductRelationResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    ProductEntity toEntity(ProductRequest request);

    ProductRelationResponse toResponse(ProductEntity entity);

    void updateProduct(ProductRequest categoryRequest, @MappingTarget ProductEntity entity);
}
