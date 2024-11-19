package co.com.poli.alquilatuprofe.model.commons;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse <T> {

    public String codigo;
    public String mensaje;
    public T respuesta;

    public static <T> GeneralResponse<T> exito(T respuesta) {
        return new GeneralResponse<>("200", "Operación exitosa", respuesta);
    }

    // Método para crear una respuesta de error
    public static <T> GeneralResponse<T> error(String mensaje) {
        return new GeneralResponse<>("500", mensaje, null);
    }
}
