package com.rigo.local.storage.localStorageProyect.infrastructure.services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.CategoryRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.CategoryResponse;
import com.rigo.local.storage.localStorageProyect.api.errors.DuplicateEntryException;
import com.rigo.local.storage.localStorageProyect.domain.entities.CategoryEntity;
import com.rigo.local.storage.localStorageProyect.domain.repositories.CategoryRepository;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IcategoryService;
import com.rigo.local.storage.localStorageProyect.infrastructure.mappers.CategoryMapper;
import com.rigo.local.storage.localStorageProyect.utils.enums.ErrorMessages;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class CategoryService implements IcategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public Page<CategoryResponse> getAll(Pageable pageable) {
        return this.categoryRepository.findAll(pageable)
                .map(this.categoryMapper::toResponse);
    }


    @Override
    public CategoryResponse create(CategoryRequest request) {

        CategoryEntity existingCategory = this.categoryRepository.findByName(request.getName());

        if (existingCategory != null) {

            // Si la categoría ya existe, lanzar una excepción personalizada
            throw new DuplicateEntryException(request.getName());

        }


        CategoryEntity newCategory = this.categoryMapper.toEntity(request);
        CategoryEntity savedCategory = this.categoryRepository.save(newCategory);

        return this.categoryMapper.toResponse(savedCategory);
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) throws BadRequestException {

        CategoryEntity category = this.find(id);

        this.categoryMapper.updateCategory(request, category);
        CategoryEntity savedCategory = this.categoryRepository.save(category);

        return this.categoryMapper.toResponse(savedCategory);
    }


    @Override
    public void delete(Long id) throws BadRequestException {

        CategoryEntity category = this.find(id);

        this.categoryRepository.delete(category);

    }
    //Metodo para buscar por id con manejo de excepciones

    private CategoryEntity find(Long id) throws BadRequestException {

        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("category")));
    }


}
