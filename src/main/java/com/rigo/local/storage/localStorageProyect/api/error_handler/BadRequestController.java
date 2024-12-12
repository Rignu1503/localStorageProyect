package com.rigo.local.storage.localStorageProyect.api.error_handler;

import com.rigo.local.storage.localStorageProyect.api.errors.BaseErrorResponse;
import com.rigo.local.storage.localStorageProyect.api.errors.ErrorsResp;
import com.rigo.local.storage.localStorageProyect.api.errors.DuplicateEntryException;  // Asegúrate de importar la excepción
import com.rigo.local.storage.localStorageProyect.api.errors.InsufficientStockException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleBadRequest(MethodArgumentNotValidException exception) {
        List<Map<String, String>> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getDefaultMessage());
            error.put("field", e.getField());
            errors.add(error);
        });

        return ErrorsResp.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    public BaseErrorResponse handleError(BadRequestException exception) {
        List<Map<String, String>> errors = new ArrayList<>();
        Map<String, String> error = new HashMap<>();
        error.put("id", exception.getMessage());

        errors.add(error);

        return ErrorsResp.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public BaseErrorResponse handleDuplicateEntry(DuplicateEntryException exception) {
        List<Map<String, String>> errors = new ArrayList<>();
        Map<String, String> error = new HashMap<>();
        error.put("error", exception.getMessage());

        errors.add(error);

        return ErrorsResp.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(InsufficientStockException.class)
    public BaseErrorResponse handleInsufficientStock(InsufficientStockException exception) {
        List<Map<String, String>> errors = new ArrayList<>();
        Map<String, String> error = new HashMap<>();
        error.put("error", exception.getMessage());

        errors.add(error);

        return ErrorsResp.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }


}