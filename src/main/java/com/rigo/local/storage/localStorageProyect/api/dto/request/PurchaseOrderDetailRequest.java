package com.rigo.local.storage.localStorageProyect.api.dto.request;

import com.rigo.local.storage.localStorageProyect.domain.entities.PurchaseOrderEntity;
import jakarta.mail.internet.InternetAddress;
import jakarta.validation.constraints.Max;
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
public class PurchaseOrderDetailRequest {

    @NotNull(message = "Quantity cannot be null")
    @PositiveOrZero(message = "Quantity must be greater than or equal to 0")
    private Integer quantity;

    @NotNull(message = "Unit price cannot be null")
    @Positive(message = "Unit price must be greater than 0")
    private Double unitPrice;

    @NotNull(message = "Product cannot be null")
    private Long productId;

}
