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
public class ClientRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email is required")
    private String email;

    @NotNull(message = "Phone is required")
    private int phone;



}
