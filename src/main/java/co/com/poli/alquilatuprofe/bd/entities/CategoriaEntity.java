package co.com.poli.alquilatuprofe.bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nombre;
    private Integer idCategoriaPadre;
    private String descripcion;
    private String activo;
    private String rutaImagen;
    private String rutaBuscador;
}
