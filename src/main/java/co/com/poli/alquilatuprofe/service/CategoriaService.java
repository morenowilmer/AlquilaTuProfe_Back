package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.model.commons.Categoria;
import co.com.poli.alquilatuprofe.model.requester.RegistrarCategoriaRequester;

import java.io.IOException;
import java.util.List;

public interface CategoriaService {

    List<Categoria> consultarCategorias() throws IOException;
    List<Categoria> consultarSubCategorias(Integer idCategoriaPadre) throws Exception;
    Categoria registrarCategoria(RegistrarCategoriaRequester requester) throws Exception;
}
