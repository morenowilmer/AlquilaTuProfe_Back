package co.com.poli.alquilatuprofe.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumEstadoMatricula {
    MATRICULADO("Matriculado", "MATRIC"),
    CANCELADO("Cancelado", "CANCEL"),
    COMPLETADO("Completado", "COMPLE"),
    ;

    private String nombre;
    private String valor;
}
