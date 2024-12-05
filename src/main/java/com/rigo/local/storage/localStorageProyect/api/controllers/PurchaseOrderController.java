package com.rigo.local.storage.localStorageProyect.api.controllers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.PurchaseOrderRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.request.Update.PurchaseOrderRequestUpdate;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.PurchaseOrderRelationResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.services.PurchaseOrderService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "purchaseOrder")
@AllArgsConstructor
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping
    public ResponseEntity<Page<PurchaseOrderRelationResponse>> getAllPurchaseOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(this.purchaseOrderService.getAll(pageable));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<PurchaseOrderRelationResponse> create(
            @Validated @RequestBody PurchaseOrderRequest request){
        return ResponseEntity.ok(this.purchaseOrderService.create(request));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<PurchaseOrderRelationResponse> update(
            @Validated @RequestBody PurchaseOrderRequestUpdate requestUpdate,
            @PathVariable Long id) throws BadRequestException {

        return ResponseEntity.ok(this.purchaseOrderService.update(id,requestUpdate));
    }
}
