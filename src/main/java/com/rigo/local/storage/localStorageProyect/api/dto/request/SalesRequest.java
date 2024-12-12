package com.rigo.local.storage.localStorageProyect.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesRequest {

    @NotNull(message = "Client cannot be null")
    private Long clientId;

    @NotNull(message = " ID cannot be null")
    private List<SalesDetailRequest> sales;


}
