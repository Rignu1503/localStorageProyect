package com.rigo.local.storage.localStorageProyect.infrastructure.services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ProductRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.ProductRelationResponse;
import com.rigo.local.storage.localStorageProyect.api.errors.DuplicateEntryException;
import com.rigo.local.storage.localStorageProyect.domain.entities.ProductEntity;
import com.rigo.local.storage.localStorageProyect.domain.repositories.CategoryRepository;
import com.rigo.local.storage.localStorageProyect.domain.repositories.ProductRepository;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IProductService;
import com.rigo.local.storage.localStorageProyect.infrastructure.mappers.ProductMapper;
import com.rigo.local.storage.localStorageProyect.utils.enums.ErrorMessages;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductRelationResponse create(ProductRequest request) {

        ProductEntity existingProduct = this.productRepository.findByName(request.getName());

        ProductEntity existingBarCode = this.productRepository.findByBarcode(request.getBarcode());

        if (existingProduct != null) throw new DuplicateEntryException(request.getName());
        if (existingBarCode != null) throw new DuplicateEntryException(request.getBarcode());

        ProductEntity newProduct = this.productMapper.toEntity(request);
        newProduct.setCategory(this.categoryRepository.getOne(request.getCategoryId()));//Agregamos el ID de category
        ProductEntity savedProuct = this.productRepository.save(newProduct);

        return this.productMapper.toResponse(savedProuct);
    }

    @Override
    public Page<ProductRelationResponse> getAll(Pageable pageable) {

        return this.productRepository.findAll(pageable).map(this.productMapper::toResponse);
    }

    @Override
    public ProductRelationResponse update(Long id, ProductRequest request) throws BadRequestException {

        ProductEntity product = this.find(id);

        //Asignamos categoria actualizada
        product.setCategory(categoryRepository.getOne(request.getCategoryId()));
        this.productMapper.updateProduct(request, product);

        return this.productMapper.toResponse(product);
    }

    @Override
    public void delete(Long id) throws BadRequestException {

        ProductEntity product = this.find(id);
        this.productRepository.delete(product);

    }

    private ProductEntity find(Long id) throws BadRequestException {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("category")));
    }


    @Override
    public Page<ProductRelationResponse> getProductsByCategoryName(String categoryName, Pageable pageable) {

        Page<ProductEntity> productEntities = this.productRepository.findByCategoryName(categoryName, pageable);

        return productEntities.map(this.productMapper::toResponse);
    }

    @Override
    public Page<ProductRelationResponse> getProductName(String name, Pageable pageable) {
        Page<ProductEntity> productEntity = productRepository.findByName(name, pageable);

        // Convertir la entidad a DTO
        return productEntity.map(productMapper::toResponse);
    }


}
