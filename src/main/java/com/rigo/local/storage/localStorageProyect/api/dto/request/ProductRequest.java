package com.rigo.local.storage.localStorageProyect.api.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @Size(min = 0, max = 50, message = "Title exceeds the number of characters allowed")
    @NotBlank(message = "Name is required")
    private String name;

    @Size(min = 0, max = 50, message = "description exceeds the number of characters allowe")
    private String description;

    @NotNull(message = "Price is required")
    private Double price;

    @NotBlank(message = "Barcode is required")
    private String barcode;

    @Min(value = 0, message = "stockCurrent must be greater than or equal to 0")
    @Positive(message = "The number must be positive")
    @NotNull(message = "stockCurrent is required")
    private int stockCurrent;

    @Min(value = 0, message = "stockCurrent must be greater than or equal to 0")
    @Positive(message = "The number must be positive")
    @NotNull(message = "StockCurrent is required")
    private int stockMinimun;

    @NotNull(message = "category is required")
    private Long categoryId;

}
