package co.com.poli.alquilatuprofe.model.commons;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HojaVida implements Serializable {

    private Integer id;
    private Integer idUsuario;
    private String institucion;
    private String descripcion;
    private Integer aniosExperiencia;
}
