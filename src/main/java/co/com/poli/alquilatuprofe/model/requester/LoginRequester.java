package co.com.poli.alquilatuprofe.model.requester;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequester implements Serializable {

    @NotNull
    @NotEmpty
    private String correo;
    @NotNull
    @NotEmpty
    private String contrasena;
}
