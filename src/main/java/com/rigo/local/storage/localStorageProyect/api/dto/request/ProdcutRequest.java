package com.rigo.local.storage.localStorageProyect.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdcutRequest {

    @Size(min = 0, max = 50, message = "Title exceeds the number of characters allowed")
    @NotBlank(message = "Name is required")
    private String name;

    @Size(min = 0, max = 50, message = "description exceeds the number of characters allowe")
    private String description;

    @NotNull(message = "Price is required")
    private Double price;

    @NotBlank(message = "Barcode is required")
    private String barcode;

    @Size(min = 0)
    @Positive(message = "The number must be positive")
    @NotNull(message = "stockCurrent is required")
    private int stockCurrent;

    @Size(min = 0)
    @Positive(message = "The number must be positive")
    @NotNull(message = "StockCurrent is required")
    private int stockMinimun;

    @NotNull(message = "category is required")
    private Long categoryId;

}
