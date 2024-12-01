package com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponse {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;

}