package com.rigo.local.storage.localStorageProyect.infrastructure.services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.SuppliersRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.SupplierResponse;
import com.rigo.local.storage.localStorageProyect.api.errors.DuplicateEntryException;
import com.rigo.local.storage.localStorageProyect.domain.entities.CategoryEntity;
import com.rigo.local.storage.localStorageProyect.domain.entities.SupplierEntity;
import com.rigo.local.storage.localStorageProyect.domain.repositories.SupplierRepository;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.ISupplierService;
import com.rigo.local.storage.localStorageProyect.infrastructure.mappers.SupplierMapper;
import com.rigo.local.storage.localStorageProyect.utils.enums.ErrorMessages;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class SupplierService implements ISupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Page<SupplierResponse> getAll(Pageable pageable) {

        return supplierRepository.findAll(pageable).map(supplierMapper::toResponse);
    }

    @Override
    public SupplierResponse create(SuppliersRequest request) {
        SupplierEntity existingName = this.supplierRepository.findByName(request.getName());
        SupplierEntity existingPhone = this.supplierRepository.findByPhone(request.getPhone());
        SupplierEntity existingEmail = this.supplierRepository.findByEmail(request.getEmail());
        SupplierEntity existingAddress = this.supplierRepository.findByAddress(request.getAddress());

        if (existingName != null) {
            throw new DuplicateEntryException(request.getName());
        }

        if (existingPhone != null) {
            throw new DuplicateEntryException(String.valueOf(request.getPhone()));
        }

        if (existingEmail != null) {
            throw new DuplicateEntryException(request.getEmail());
        }

        if (existingAddress != null) {
            throw new DuplicateEntryException(request.getAddress());
        }

        SupplierEntity newSupplier = this.supplierMapper.toEntity(request);
        SupplierEntity savedSupplier = this.supplierRepository.save(newSupplier);

        return this.supplierMapper.toResponse(savedSupplier);
    }

    @Override
    public void delete(Long id) throws BadRequestException {

        SupplierEntity supplier = find(id);

        this.supplierRepository.delete(supplier);
    }


    @Override
    public SupplierResponse update(Long id, SuppliersRequest request) throws BadRequestException {

        SupplierEntity supplier = find(id);

        this.supplierMapper.updateSupplier(request, supplier);
        SupplierEntity savedSupplier = this.supplierRepository.save(supplier);

        return this.supplierMapper.toResponse(savedSupplier);
    }


    //Metodo para buscar por id con manejo de excepciones
    private SupplierEntity find(Long id) throws BadRequestException {

        return this.supplierRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("supplier")));
    }



}
