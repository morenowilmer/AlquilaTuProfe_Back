package co.com.poli.alquilatuprofe.model.commons;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sesion implements Serializable {

    private String id;
    private Usuario usuario;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
