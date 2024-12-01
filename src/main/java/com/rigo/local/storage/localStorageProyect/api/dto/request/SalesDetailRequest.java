package com.rigo.local.storage.localStorageProyect.api.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesDetailRequest {


    @PositiveOrZero(message = "Quantity must be greater than or equal to 0")
    private int quantity;

    @Positive(message = "Unit price must be greater than 0")
    private Double unitPrice;

    @NotNull(message = "Sale ID cannot be null")
    private Long saleId;

    @NotNull(message = "Product ID cannot be null")
    private Long productId;

}
