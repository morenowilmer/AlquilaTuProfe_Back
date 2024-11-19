package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.CategoriaAdapter;
import co.com.poli.alquilatuprofe.model.response.Categoria;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaAdapter categoriaAdapter;

    public CategoriaServiceImpl(CategoriaAdapter categoriaAdapter) {
        this.categoriaAdapter = categoriaAdapter;
    }

    @Override
    public List<Categoria> consultarCategorias() {
        List<Categoria> categorias = categoriaAdapter.consultarCategoriasPadre();

        if (Objects.isNull(categorias) || categorias.isEmpty())
            return Collections.emptyList();

        consultarCategoriasCiclo(categorias);

        return categorias;
    }

    private void consultarCategoriasCiclo(List<Categoria> categorias) {
        if (Objects.isNull(categorias) || categorias.isEmpty())
            return;

        for (Categoria categoria : categorias) {
            List<Categoria> subCategorias = categoriaAdapter.consultarCategoriasHijo(categoria.getId());
            categoria.setSubCategorias(subCategorias);
            consultarCategoriasCiclo(subCategorias);
        }
    }
}
