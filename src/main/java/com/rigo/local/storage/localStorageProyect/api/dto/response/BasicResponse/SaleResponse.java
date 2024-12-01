package com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse;


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
public class SaleResponse {

    private Long id;
    private LocalDateTime date;
    private double total;
}
