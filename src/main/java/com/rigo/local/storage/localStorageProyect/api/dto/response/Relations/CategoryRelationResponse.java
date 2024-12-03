package com.rigo.local.storage.localStorageProyect.api.dto.response.Relations;

import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRelationResponse {

    private Long id;
    private String name;
    private ProductResponse product;
}
