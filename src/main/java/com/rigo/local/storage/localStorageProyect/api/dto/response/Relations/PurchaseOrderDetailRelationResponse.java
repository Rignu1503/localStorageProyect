package com.rigo.local.storage.localStorageProyect.api.dto.response.Relations;

import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ProductResponse;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.PurchaseOrderResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDetailRelationResponse {

    private Long id;
    private int quantity;
    private Double unitPrice;

    /*Relation*/
    private ProductResponse product;
    private PurchaseOrderResponse purchaseOrder;

}