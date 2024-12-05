package co.com.poli.alquilatuprofe.model.requester;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarCategoriaRequester implements Serializable {

    @NotNull
    private Integer idCategoriaPadre;
    @NotNull
    @NotEmpty
    private String nombre;
    @NotNull
    @NotEmpty
    private String descripcion;
    @NotNull
    @NotEmpty
    private String imagen;
}
