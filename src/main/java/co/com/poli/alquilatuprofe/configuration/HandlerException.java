package co.com.poli.alquilatuprofe.configuration;

import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.enums.EnumCodigoRespuesta;
import co.com.poli.alquilatuprofe.model.exception.ErrorException;
import co.com.poli.alquilatuprofe.model.exception.InfoException;
import co.com.poli.alquilatuprofe.model.exception.SinAutorizacionException;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {SinAutorizacionException.class, ServletException.class})
    public ResponseEntity<GeneralResponse<String>> autorizationHandleException(SinAutorizacionException ex) {
        log.error(ex.getMessage());
        GeneralResponse<String> response = GeneralResponse.<String>builder()
                .codigo(EnumCodigoRespuesta.ALERTA.getValor())
                .mensaje(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(value = InfoException.class)
    public ResponseEntity<GeneralResponse<String>> infoHandleException(InfoException ex) {
        log.error(ex.getMessage());
        GeneralResponse<String> response = GeneralResponse.<String>builder()
                .codigo(EnumCodigoRespuesta.INFORMACION.getValor())
                .mensaje(ex.getMessage()).build();
        return ResponseEntity.ok().body(response);
    }

    @ExceptionHandler(value = ErrorException.class)
    public ResponseEntity<GeneralResponse<String>> genericHandleException(ErrorException ex) {
        log.error(ex.getMessage());
        GeneralResponse<String> response = GeneralResponse.error("Ocurrio un error inesperado.");
        return ResponseEntity.ok().body(response);
    }
}
