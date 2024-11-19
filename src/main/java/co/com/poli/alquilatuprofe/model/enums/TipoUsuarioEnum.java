package co.com.poli.alquilatuprofe.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoUsuarioEnum {
    PROFESOR("Profesor", "PROFE"),
    ALUMNO("Alumno", "ALUM");

    private String nombre;
    private String value;
}
