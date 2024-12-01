package com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse;


import com.rigo.local.storage.localStorageProyect.utils.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private RoleUser role;

}