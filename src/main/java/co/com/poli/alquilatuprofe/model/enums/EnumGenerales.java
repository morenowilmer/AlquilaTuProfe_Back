package co.com.poli.alquilatuprofe.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumGenerales {
    NO_AUTORIZADO("NO_AUTORIZADO", "Usuario no autorizado."),
    SESION_EXPIRADA("SESION_EXPIRADA", "Sesión expirada."),;

    private String valor;
    private String informacion;

    public void obtenerInformacion(String valor) {
    }
}
