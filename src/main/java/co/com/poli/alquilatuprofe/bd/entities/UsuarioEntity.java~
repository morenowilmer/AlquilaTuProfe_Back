package co.com.poli.alquilatuprofe.bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    @OneToOne
    @JoinColumn(name = "tipo_doc", referencedColumnName = "id", insertable = false, updatable = false)
    private TipoDocumentoEntity tipoDocumento;
    private String tipoUsuario;
    private String identificacion;
    private String celular;
    private String correo;
    private String contrasena;
    private String activo;
    private Date fechaNacimiento;
    private String departamento;
    private String ciudad;
    private String direccion;
    private String rutaFoto;
    private Integer nroClases;
    private Integer nroHorasClases;
}
