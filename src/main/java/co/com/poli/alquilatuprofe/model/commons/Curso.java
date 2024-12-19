package co.com.poli.alquilatuprofe.model.commons;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Curso implements Serializable {

    private Integer id;
    private Integer idCategoria;
    private String categoria;
    private Integer idProfesor;
    private String nombre;
    private String descripcion;
    private Integer nroHoras;
    private Double valorHora;
    private Double calificacion;
    private Integer nroSolicitudes;
    private String rutaImagen;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Bogota")
    private LocalDateTime fechaInicio;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Bogota")
    private LocalDateTime fechaFin;
}
