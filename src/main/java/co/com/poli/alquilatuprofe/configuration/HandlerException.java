package co.com.poli.alquilatuprofe.configuration;

import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<GeneralResponse<String>> handleException(Exception ex) {
        log.error(ex.getMessage());
        GeneralResponse<String> response = GeneralResponse.error("Ocurrio un error inesperado.");
        return ResponseEntity.internalServerError().body(response);
    }
}
