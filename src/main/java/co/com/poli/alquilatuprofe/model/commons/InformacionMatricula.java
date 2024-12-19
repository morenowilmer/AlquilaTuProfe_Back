package co.com.poli.alquilatuprofe.model.commons;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformacionMatricula implements Serializable {

    private Integer idMatricula;
    private Integer idCurso;
    private Integer idCategoria;
    private Integer idAlumno;
    private Integer idProfesor;
    private UsuarioInfoBasica profesor;
    private String nombreCurso;
    private String descripcionCurso;
    private Double calificacionCurso;
    private Integer nroSolicitudes;
    private String rutaImagen;
    private String imagen;
    private LocalDateTime fechaMatricula;
    private LocalDateTime fechaCurso;
    private Integer horaInicio;
    private Integer horaFin;
    private String estadoMatricula;
}
