package co.com.poli.alquilatuprofe.bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "hoja_vida")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HojaVidaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idUsuario;
    private String institucion;
    private String descripcion;
    private Integer aniosExperiencia;
}
