package co.com.poli.alquilatuprofe.bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "matricula")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idUsuario;
    private Integer idCurso;
    private LocalDateTime fechaMatricula;
    private LocalDateTime fechaCurso;
    private Integer horaInicio;
    private Integer horaFin;
    private String estado;
}
