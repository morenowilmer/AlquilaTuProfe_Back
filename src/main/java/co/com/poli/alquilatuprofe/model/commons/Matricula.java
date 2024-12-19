package co.com.poli.alquilatuprofe.model.commons;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Matricula implements Serializable {

    private Integer id;
    private Integer idUsuario;
    private Integer idCurso;
    private LocalDateTime fechaMatricula;
    private LocalDateTime fechaCurso;
    private Integer horaInicio;
    private Integer horaFin;
    private String estado;
}
