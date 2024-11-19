package co.com.poli.alquilatuprofe.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Categoria implements Serializable {

    private Integer id;
    private Integer idCategoriaPadre;
    private String nombre;
    private String descripcion;
    private String activo;
    private String rutaImagen;
    private String rutaBuscador;
    private List<Categoria> subCategorias;
}
