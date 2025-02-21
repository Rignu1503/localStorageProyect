package com.rigo.local.storage.localStorageProyect.api.controllers;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ClientRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ClientResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IClientService;
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
@RequestMapping(path = "client")
@AllArgsConstructor
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ClientController {

    @Autowired
    private final IClientService clientService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping
    public ResponseEntity<Page<ClientResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(clientService.getAll(pageable));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<ClientResponse> create(
            @Validated @RequestBody ClientRequest request) throws BadRequestException {

        return ResponseEntity.ok(this.clientService.create(request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientResponse> update(
            @Validated @RequestBody ClientRequest request,
            @PathVariable Long id) throws BadRequestException {

        return ResponseEntity.ok(this.clientService.update(id, request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ClientResponse> delete(
            @PathVariable Long id) throws BadRequestException {

        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
