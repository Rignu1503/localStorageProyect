package com.rigo.local.storage.localStorageProyect.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersRequest {

    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Phone is required")
    private int phone;

    @Email(message = "Email must be valid")
    @NotNull(message = "Email is required")
    private String email;

    @NotBlank(message = "Address cannot be blank")
    @NotNull(message = "Address is required")
    private String address;

}
