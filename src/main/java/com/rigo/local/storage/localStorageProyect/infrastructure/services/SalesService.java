package com.rigo.local.storage.localStorageProyect.infrastructure.services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.SalesRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.SalesRelationResponse;
import com.rigo.local.storage.localStorageProyect.api.errors.InsufficientStockException;
import com.rigo.local.storage.localStorageProyect.domain.entities.ProductEntity;
import com.rigo.local.storage.localStorageProyect.domain.entities.SalesDetailEntity;
import com.rigo.local.storage.localStorageProyect.domain.entities.SalesEntity;
import com.rigo.local.storage.localStorageProyect.domain.repositories.ClientRepository;
import com.rigo.local.storage.localStorageProyect.domain.repositories.ProductRepository;
import com.rigo.local.storage.localStorageProyect.domain.repositories.SalesDetailRepository;
import com.rigo.local.storage.localStorageProyect.domain.repositories.SalesRepository;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IsalesService;
import com.rigo.local.storage.localStorageProyect.infrastructure.mappers.SalesMapper;
import com.rigo.local.storage.localStorageProyect.utils.enums.ErrorMessages;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SalesService implements IsalesService {

    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private SalesMapper salesMapper;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SalesDetailRepository salesDetailRepository;


    @Override
    public SalesRelationResponse create(SalesRequest request) throws BadRequestException {

        SalesEntity newSales = this.salesMapper.toEntity(request);

        newSales.setClient(this.clientRepository.findById(request.getClientId())
            .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("client"))));

        ArrayList<SalesDetailEntity> salesDetailEntities = new ArrayList<>();

        AtomicReference<Double> totalSales = new AtomicReference<>(0.0);

        if (request.getSales() != null){
            request.getSales().forEach(salesPrice -> {
                // Actualizar el total
                totalSales.updateAndGet(v -> v +
                        (salesPrice.getQuantity() *
                                (salesPrice.getUnitPrice() != null ? salesPrice.getUnitPrice() : 0.0))
                );

            });
        }

        newSales.setTotal(totalSales.get());
        SalesEntity savedSales = this.salesRepository.save(newSales);

        if (request.getSales() != null) {
            request.getSales().forEach(salesDetailDetail -> {
                ProductEntity product = null;

                try {
                    product = productRepository.findById(salesDetailDetail.getProductId())
                            .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("product")));
                } catch (BadRequestException e) {
                    throw new RuntimeException(e);
                }


                SalesDetailEntity salesDetail = new SalesDetailEntity();
                salesDetail.setQuantity(salesDetailDetail.getQuantity());
                salesDetail.setUnitPrice(salesDetailDetail.getUnitPrice());
                salesDetail.setProduct(product);
                salesDetail.setSale(savedSales);

                if (salesDetail.getQuantity() > product.getStockCurrent()){
                    throw new InsufficientStockException("Insufficient stock for product: " + product.getName() + " stock: " + product.getStockCurrent());
                }

                salesDetailEntities.add(salesDetail);

                this.salesDetailRepository.save(salesDetail);

            });
        }

        savedSales.setSalesDetailList(salesDetailEntities);

        return this.salesMapper.toResponse(savedSales);
    }

    @Override
    public Page<SalesRelationResponse> getAll(Pageable pageable) {
        return this.salesRepository.findAll(pageable).map(this.salesMapper::toResponse);
    }

}
