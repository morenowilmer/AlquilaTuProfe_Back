package co.com.poli.alquilatuprofe.bd.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tipo_documento")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoEntity implements Serializable {

    @Id
    private Integer id;
    private String nombre;
    private String valor;
    private String activo;
}
