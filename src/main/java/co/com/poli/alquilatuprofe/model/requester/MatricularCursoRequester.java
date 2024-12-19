package co.com.poli.alquilatuprofe.model.requester;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatricularCursoRequester implements Serializable {

    @NotNull
    private Integer idUsuario;
    @NotNull
    private Integer idCurso;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Bogota")
    private LocalDateTime fechaCurso;
    @NotNull
    private Integer horaInicio;
}
