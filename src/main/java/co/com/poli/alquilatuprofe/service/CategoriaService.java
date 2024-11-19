package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.model.commons.Categoria;

import java.io.IOException;
import java.util.List;

public interface CategoriaService {

    List<Categoria> consultarCategorias() throws IOException;
}
