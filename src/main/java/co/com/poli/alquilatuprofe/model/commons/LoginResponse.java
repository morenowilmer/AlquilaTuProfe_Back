package co.com.poli.alquilatuprofe.model.commons;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {

    private Integer id;
    private String nombre;
    private String nombreCompleto;
    private String foto;
    private String token;
}
