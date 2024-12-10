package com.rigo.local.storage.localStorageProyect.api.dto.response.Relations;

import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.PurchaseOrderDetailResponse;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.SupplierResponse;
import com.rigo.local.storage.localStorageProyect.utils.enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderRelationResponse {

    private Long id;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    private PurchaseStatus status;

    /*Relation*/
    private SupplierResponse supplier;
    private List<PurchaseOrderDetailResponse> orderDetail;

}