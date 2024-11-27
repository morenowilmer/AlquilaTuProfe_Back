package co.com.poli.alquilatuprofe.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumCodigoRespuesta {
    ALERTA("ALERTA"),
    EXITO("OK"),
    ERROR("ERROR"),
    INFORMACION("INFO");

    private String valor;
}
