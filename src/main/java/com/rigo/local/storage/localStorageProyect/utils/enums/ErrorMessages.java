package com.rigo.local.storage.localStorageProyect.utils.enums;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ErrorMessages {
    private final String mensaje = "";

    public static String IdNotFound(String entity) {
        final String message = "There are no records in the entity %s with the supplied id";
        return String.format(message, entity);
    }

    public static String nameNotFound(String entity) {
        final String message = "There are no records in the entity %s with the supplied name";
        return String.format(message, entity);
    }

}