package com.rigo.local.storage.localStorageProyect.api.dto.request;

import com.rigo.local.storage.localStorageProyect.utils.enums.PurchaseStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderRequest {

    @NotNull(message = "Status cannot be null")
    private PurchaseStatus status;

    @NotNull(message = "Supplier ID cannot be null")
    private Long supplierId;
    @NotNull(message = " ID cannot be null")
    private List<PurchaseOrderDetailRequest> products;

}
