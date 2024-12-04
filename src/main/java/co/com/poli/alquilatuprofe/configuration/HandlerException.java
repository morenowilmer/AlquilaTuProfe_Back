package co.com.poli.alquilatuprofe.configuration;

import co.com.poli.alquilatuprofe.model.commons.GeneralResponse;
import co.com.poli.alquilatuprofe.model.enums.EnumCodigoRespuesta;
import co.com.poli.alquilatuprofe.model.enums.EnumGenerales;
import co.com.poli.alquilatuprofe.model.exception.ErrorException;
import co.com.poli.alquilatuprofe.model.exception.InfoException;
import co.com.poli.alquilatuprofe.model.exception.SinAutorizacionException;
import co.com.poli.alquilatuprofe.util.EnumsUtil;
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

    @ExceptionHandler(value = {SinAutorizacionException.class})
    public ResponseEntity<GeneralResponse<String>> autorizationHandleException(SinAutorizacionException ex) {
        log.error(ex.getMessage());
        GeneralResponse<String> response = GeneralResponse.<String>builder()
                .codigo(EnumCodigoRespuesta.ALERTA.getValor())
                .mensaje(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(value = ServletException.class)
    public ResponseEntity<GeneralResponse<String>> autorization2HandleException(ServletException ex) {
        log.error(ex.getMessage());

        if (ex.getMessage().equals(EnumGenerales.NO_AUTORIZADO.getValor()) ||
                ex.getMessage().equals(EnumGenerales.SESION_EXPIRADA.getValor())) {
            GeneralResponse<String> response = GeneralResponse.<String>builder()
                    .codigo(EnumCodigoRespuesta.ALERTA.getValor())
                    .mensaje(EnumsUtil.enumGeneralesInformacion(ex.getMessage())).build();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return ResponseEntity.ok().body(GeneralResponse.error("Ocurrio un error inesperado."));
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
