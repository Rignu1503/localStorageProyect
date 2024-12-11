package com.rigo.local.storage.localStorageProyect.api.dto.response.Relations;


import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.SaleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRelationResponse {

    private Long id;
    private String name;
    private String email;
    private Long phone;

    /*Relation*/
    private SaleResponse sales;
}
