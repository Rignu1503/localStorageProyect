package com.rigo.local.storage.localStorageProyect.api.dto.response.Relations;


import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ClientResponse;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.SalesDetailResponse;
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
public class SalesRelationResponse {

    private Long id;
    private LocalDateTime date;
    private double total;

    /*Relation*/
    private ClientResponse client;
    private List<SalesDetailResponse> salesDetails;
}
