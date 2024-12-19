package co.com.poli.alquilatuprofe.bd.entities;

import co.com.poli.alquilatuprofe.model.commons.UsuarioInfoBasica;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "informacion_matricula")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformacionMatriculaEntity implements Serializable {

    @Id
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
    private LocalDateTime fechaMatricula;
    private LocalDateTime fechaCurso;
    private Integer horaInicio;
    private Integer horaFin;
    private String estadoMatricula;
}
