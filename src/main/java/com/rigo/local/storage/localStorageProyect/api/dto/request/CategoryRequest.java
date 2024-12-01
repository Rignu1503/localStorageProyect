package com.rigo.local.storage.localStorageProyect.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    @Size(min = 0, max = 100, message = "name exceeds the number of characters allowed")
    @NotBlank(message = "name is required")
    private String name;





}
