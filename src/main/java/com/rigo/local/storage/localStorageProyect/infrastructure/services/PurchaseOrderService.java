package com.rigo.local.storage.localStorageProyect.infrastructure.services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.PurchaseOrderRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.request.Update.PurchaseOrderRequestUpdate;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.PurchaseOrderRelationResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.PurchaseOrderEntity;
import com.rigo.local.storage.localStorageProyect.domain.repositories.PurchaseOrderRepository;
import com.rigo.local.storage.localStorageProyect.domain.repositories.SupplierRepository;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IPurchaseOrderService;
import com.rigo.local.storage.localStorageProyect.infrastructure.mappers.PurchaseOrderMapper;
import com.rigo.local.storage.localStorageProyect.utils.enums.ErrorMessages;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PurchaseOrderService implements IPurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private SupplierRepository supplierRepository;


    @Override
    public PurchaseOrderRelationResponse create(PurchaseOrderRequest request) {

        PurchaseOrderEntity newPurchaseOrder = this.purchaseOrderMapper.toEntity(request);
        newPurchaseOrder.setSupplier(this.supplierRepository.getOne(request.getSupplierId()));
        PurchaseOrderEntity savedPurchaseOrder = this.purchaseOrderRepository.save(newPurchaseOrder);

        return this.purchaseOrderMapper.toResponse(savedPurchaseOrder);
    }

    @Override
    public Page<PurchaseOrderRelationResponse> getAll(Pageable pageable) {

        return this.purchaseOrderRepository.findAll(pageable)
                .map(purchaseOrderMapper::toResponse);
    }

    @Override
    public PurchaseOrderRelationResponse update(Long id, PurchaseOrderRequestUpdate request) throws BadRequestException {

        request.setDateUpdate(LocalDateTime.now());
        PurchaseOrderEntity purchaseOrder = this.findById(id);
        this.purchaseOrderMapper.updatePurchaseOrder(request, purchaseOrder);

        return this.purchaseOrderMapper.toResponse(purchaseOrder);
    }

    private PurchaseOrderEntity findById(Long id) throws BadRequestException {

        return this.purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("category")));
    }
}
