package co.com.poli.alquilatuprofe.model.requester;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarCursoRequester implements Serializable {

    @NotNull
    private Integer idCategoria;
    @NotNull
    private Integer idProfesor;
    @NotNull
    @NotEmpty
    private String nombre;
    @NotEmpty
    @NotNull
    private String descripcion;
    @NotNull
    private Integer nroHoras;
    @NotNull
    private Double valorHora;
    @NotNull
    @NotEmpty
    private String imagen;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Bogota")
    private LocalDateTime fechaInicio;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Bogota")
    private LocalDateTime fechaFin;
}
