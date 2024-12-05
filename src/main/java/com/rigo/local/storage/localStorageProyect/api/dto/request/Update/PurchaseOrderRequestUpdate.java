package com.rigo.local.storage.localStorageProyect.api.dto.request.Update;

import com.rigo.local.storage.localStorageProyect.utils.enums.PurchaseStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderRequestUpdate {

    @NotNull(message = "Status cannot be null")
    private PurchaseStatus status;

    private LocalDateTime dateUpdate;
}
