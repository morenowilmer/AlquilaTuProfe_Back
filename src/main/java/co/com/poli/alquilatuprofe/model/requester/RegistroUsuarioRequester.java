package co.com.poli.alquilatuprofe.model.requester;

import co.com.poli.alquilatuprofe.model.commons.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistroUsuarioRequester implements Serializable {

    @NotNull
    @NotEmpty
    private String nombre;
    @NotNull
    @NotEmpty
    private String apellido;
    @NotNull
    private TipoDocumento tipoDocumento;
    @NotNull
    @NotEmpty
    private String identificacion;
    @NotNull
    @NotEmpty
    private String celular;
    @NotNull
    @NotEmpty
    private String correo;
    @NotNull
    @NotEmpty
    private String contrasena;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "America/Bogota")
    private Date fechaNacimiento;
    @NotNull
    @NotEmpty
    private String departamento;
    @NotNull
    @NotEmpty
    private String ciudad;
    @NotNull
    @NotEmpty
    private String direccion;
    @NotNull
    @NotEmpty
    private String fotoBase64;
}
