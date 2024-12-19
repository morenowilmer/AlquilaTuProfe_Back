package co.com.poli.alquilatuprofe.bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "curso")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idCategoria;
    @Column(name = "id_usuario")
    private Integer idProfesor;
    private String nombre;
    private String descripcion;
    private Integer nroHoras;
    private Double valorHora;
    private Double calificacion;
    private Integer nroSolicitudes;
    private String rutaImagen;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
