package co.com.poli.alquilatuprofe.model.commons;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements Serializable {

    private Integer id;
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private String identificacion;
    private String celular;
    private String correo;
    private String contrasena;
    private String activo;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "America/Bogota")
    private Date fechaNacimiento;
    private String departamento;
    private String ciudad;
    private String direccion;
    private String rutaFoto;
    private String foto;
    private Integer nroClases;
    private Integer nroHorasClases;
    private List<HojaVida> hojaVidas;
}
