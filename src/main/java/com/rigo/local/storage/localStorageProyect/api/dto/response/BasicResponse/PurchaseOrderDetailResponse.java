package com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDetailResponse {

    private Long id;
    private int quantity;
    private Double unitPrice;

}