package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.response.Categoria;

import java.util.List;

public interface CategoriaAdapter {

    List<Categoria> consultarCategoriasPadre();

    List<Categoria> consultarCategoriasHijo(Integer idPadre);
}
