package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.commons.Categoria;

import java.util.List;

public interface CategoriaAdapter {
    Categoria consultarCategoria(Integer id);

    List<Categoria> consultarCategoriasPadre();

    List<Categoria> consultarCategoriasHijo(Integer idPadre);
    Categoria registrarCategoria(Categoria categoria);
}
