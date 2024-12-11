package com.rigo.local.storage.localStorageProyect.infrastructure.services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.PurchaseOrderRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.request.Update.PurchaseOrderRequestUpdate;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.PurchaseOrderRelationResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.ProductEntity;
import com.rigo.local.storage.localStorageProyect.domain.entities.PurchaseOrderDetailEntity;
import com.rigo.local.storage.localStorageProyect.domain.entities.PurchaseOrderEntity;
import com.rigo.local.storage.localStorageProyect.domain.repositories.ProductRepository;
import com.rigo.local.storage.localStorageProyect.domain.repositories.PurchaseOrderDetailRepository;
import com.rigo.local.storage.localStorageProyect.domain.repositories.PurchaseOrderRepository;
import com.rigo.local.storage.localStorageProyect.domain.repositories.SupplierRepository;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IPurchaseOrderService;
import com.rigo.local.storage.localStorageProyect.infrastructure.mappers.PurchaseOrderMapper;
import com.rigo.local.storage.localStorageProyect.utils.enums.ErrorMessages;
import com.rigo.local.storage.localStorageProyect.utils.enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PurchaseOrderService implements IPurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;


    @Override
    public PurchaseOrderRelationResponse create(PurchaseOrderRequest request) throws BadRequestException {

        // Crear la entidad de la orden de compra
        PurchaseOrderEntity newPurchaseOrder = this.purchaseOrderMapper.toEntity(request);

        // Asignar el proveedor a la orden
        newPurchaseOrder.setSupplier(this.supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("supplier"))));

        // Guardar la orden de compra en la base de datos
        PurchaseOrderEntity savedPurchaseOrder = this.purchaseOrderRepository.save(newPurchaseOrder);

        // Lista para agregar a la respuesta
        ArrayList<PurchaseOrderDetailEntity> purchaseOrderDetails = new ArrayList<>();

        // Procesar los detalles de la orden (productos asociados)
        if (request.getProducts() != null) {
            request.getProducts().forEach(productDetail -> {
                PurchaseOrderDetailEntity detailEntity = new PurchaseOrderDetailEntity();

                // Buscar el producto en la base de datos
                ProductEntity product = null;
                try {
                    product = productRepository.findById(productDetail.getProductId())
                            .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("product")));
                } catch (BadRequestException e) {
                    throw new RuntimeException(e);
                }

                // Configurar los detalles de la orden
                detailEntity.setPurchaseOrder(savedPurchaseOrder);
                detailEntity.setProduct(product);
                detailEntity.setQuantity(productDetail.getQuantity());
                detailEntity.setUnitPrice(productDetail.getUnitPrice());

                purchaseOrderDetails.add(detailEntity);

                // Guardar cada detalle en la base de datos
                purchaseOrderDetailRepository.save(detailEntity);

            });
        }

        savedPurchaseOrder.setPurchaseOrderDetailList(purchaseOrderDetails);

        // Retornar la respuesta mapeada
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
        PurchaseOrderEntity purchaseOrder = this.find(id);

        // Obtener el estado anterior
        PurchaseStatus previousStatus = purchaseOrder.getStatus();

        // Actualizar los campos de la orden
        this.purchaseOrderMapper.updatePurchaseOrder(request, purchaseOrder);

        // Verificar si el estado cambió a RECEIVED
        if (request.getStatus() == PurchaseStatus.RECEIVED && previousStatus != PurchaseStatus.RECEIVED) {
            // Actualizar el stock de los productos asociados
            purchaseOrder.getPurchaseOrderDetailList().forEach(detail -> {
                ProductEntity product = detail.getProduct();
                int newStock = product.getStockCurrent() + detail.getQuantity();
                product.setStockCurrent(newStock);
                System.out.println(product);

                // Guardar el producto actualizado
                this.productRepository.save(product);
            });
        }

        // Guardar la orden actualizada
        PurchaseOrderEntity updatedPurchaseOrder = this.purchaseOrderRepository.save(purchaseOrder);

        // Retornar la respuesta mapeada
        return this.purchaseOrderMapper.toResponse(updatedPurchaseOrder);
    }

    private PurchaseOrderEntity find(Long id) throws BadRequestException {

        return this.purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("PurchaseOrder")));
    }
}
