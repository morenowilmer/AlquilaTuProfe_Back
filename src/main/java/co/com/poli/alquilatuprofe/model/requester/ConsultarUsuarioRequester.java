package co.com.poli.alquilatuprofe.model.requester;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarUsuarioRequester implements Serializable {

    @NotNull
    private String tipoIdentificacion;
    @NotNull
    private String identificacion;
    @NotNull
    private String tipoUsuario;
}
