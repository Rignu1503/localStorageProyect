package com.rigo.local.storage.localStorageProyect.api.controllers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.SalesRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.Relations.SalesRelationResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IsalesService;
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
@RequestMapping(path = "sales")
@AllArgsConstructor
public class SalesController {

    @Autowired
    private final IsalesService salesService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping
    public ResponseEntity<Page<SalesRelationResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(salesService.getAll(pageable));

    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<SalesRelationResponse> create(
            @Validated @RequestBody SalesRequest request) throws BadRequestException {
        return ResponseEntity.ok(this.salesService.create(request));
    }


}
