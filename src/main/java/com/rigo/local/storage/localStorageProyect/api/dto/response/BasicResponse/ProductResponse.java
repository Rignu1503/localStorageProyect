package com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String barcode;
    private int stockCurrent;
    private int stockMinimun;

}
