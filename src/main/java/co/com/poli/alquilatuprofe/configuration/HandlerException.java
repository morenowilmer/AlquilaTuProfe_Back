package co.com.poli.alquilatuprofe.configuration;

import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.enums.EnumCodigoRespuesta;
import co.com.poli.alquilatuprofe.model.exception.ErrorException;
import co.com.poli.alquilatuprofe.model.exception.InfoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@Order(1)
public class HandlerException {

    @ExceptionHandler(InfoException.class)
    public ResponseEntity<GeneralResponse<String>> infoHandleException(InfoException ex) {
        log.error(ex.getMessage());
        GeneralResponse<String> response = GeneralResponse.<String>builder()
                .codigo(EnumCodigoRespuesta.INFORMACION.getValor())
                .mensaje(ex.getMessage()).build();
        return ResponseEntity.ok().body(response);
    }

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<GeneralResponse<String>> genericHandleException(ErrorException ex) {
        log.error(ex.getMessage());
        GeneralResponse<String> response = GeneralResponse.error("Ocurrio un error inesperado.");
        return ResponseEntity.ok().body(response);
    }
}
