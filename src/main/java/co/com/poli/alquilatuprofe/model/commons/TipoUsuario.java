package co.com.poli.alquilatuprofe.model.commons;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuario implements Serializable {

    private String nombre;
    private String valor;
}
