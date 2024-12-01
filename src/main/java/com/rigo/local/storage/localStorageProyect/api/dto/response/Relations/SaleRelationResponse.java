package com.rigo.local.storage.localStorageProyect.api.dto.response.Relations;


import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleRelationResponse {

    private Long id;
    private LocalDateTime date;
    private double total;

    /*Relation*/
    private ClientResponse client;
}
