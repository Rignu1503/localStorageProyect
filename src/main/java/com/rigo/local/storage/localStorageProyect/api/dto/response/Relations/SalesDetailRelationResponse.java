package com.rigo.local.storage.localStorageProyect.api.dto.response.Relations;

import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ProductResponse;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.SaleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesDetailRelationResponse {

    private Long id;
    private int quantity;
    private Double unitPrice;

    /*Relation*/
    private ProductResponse product;
    private SaleResponse sale;

}
