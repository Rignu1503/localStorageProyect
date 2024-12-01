package com.rigo.local.storage.localStorageProyect.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesRequest {


    @Positive(message = "Total must be greater than 0")
    @NotNull(message = "Total cannot be null")
    private Double total;

    @NotNull(message = "Client cannot be null")
    private Long clientId;
}
