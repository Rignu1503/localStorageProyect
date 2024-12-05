package com.rigo.local.storage.localStorageProyect.api.controllers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ProductRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.ProductRelationResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IProductService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping(path = "product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final IProductService productService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<ProductRelationResponse> createProduct(
            @Validated @RequestBody ProductRequest request) {

        return ResponseEntity.ok(this.productService.create(request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @GetMapping(path = "/{nameCategory}")
    public ResponseEntity<Page<ProductRelationResponse>> getByNameCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @PathVariable String nameCategory
    ){
        Pageable pageable = PageRequest.of(page, size);

        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(this.productService.getProductsByCategoryName(nameCategory, pageable));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @GetMapping
    public ResponseEntity<Page<ProductRelationResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);

        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(this.productService.getAll(pageable));
    }



    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductRelationResponse> updateProduct(
            @Validated @RequestBody ProductRequest request,
            @PathVariable Long id) throws BadRequestException{

        return ResponseEntity.ok(this.productService.update(id, request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductRelationResponse> deleteProduct(
            @PathVariable Long id) throws BadRequestException{

        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}