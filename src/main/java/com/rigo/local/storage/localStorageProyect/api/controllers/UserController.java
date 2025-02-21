package com.rigo.local.storage.localStorageProyect.api.controllers;


import com.rigo.local.storage.localStorageProyect.api.dto.request.UserRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.UserResponse;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IUserService;
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
@RequestMapping(path = "user")
@AllArgsConstructor
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class UserController {

    @Autowired
    private final IUserService userService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(userService.getAll(pageable));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<UserResponse> create(
            @Validated @RequestBody UserRequest request) throws BadRequestException {


        return ResponseEntity.ok(this.userService.create(request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> update(
            @Validated @RequestBody UserRequest request,
            @PathVariable Long id) throws BadRequestException {

        return ResponseEntity.ok(this.userService.update(id, request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> delete(
            @PathVariable Long id) throws BadRequestException {

        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
