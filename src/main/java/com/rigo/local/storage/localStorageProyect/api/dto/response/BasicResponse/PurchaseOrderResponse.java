package com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse;

import com.rigo.local.storage.localStorageProyect.utils.enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderResponse {

    private Long id;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    private PurchaseStatus status;

}