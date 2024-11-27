package co.com.poli.alquilatuprofe.bd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "SESION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SesionEntity implements Serializable {

    @Id
    private String id;
    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuarioEntity usuario;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
