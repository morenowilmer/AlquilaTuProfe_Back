package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.CategoriaAdapter;
import co.com.poli.alquilatuprofe.model.commons.Categoria;
import co.com.poli.alquilatuprofe.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Value("${imagenes.ruta.base}")
    private String rutaBaseImagenes;

    private final CategoriaAdapter categoriaAdapter;

    public CategoriaServiceImpl(CategoriaAdapter categoriaAdapter) {
        this.categoriaAdapter = categoriaAdapter;
    }

    @Override
    public List<Categoria> consultarCategorias() throws IOException {
        List<Categoria> categorias = categoriaAdapter.consultarCategoriasPadre();

        if (Objects.isNull(categorias) || categorias.isEmpty())
            return Collections.emptyList();

        consultarCategoriasCiclo(categorias);

        return categorias;
    }

    private void consultarCategoriasCiclo(List<Categoria> categorias) throws IOException {
        if (Objects.isNull(categorias) || categorias.isEmpty())
            return;

        for (Categoria categoria : categorias) {
            String rutaImgCompleta = rutaBaseImagenes + categoria.getRutaImagen();
            String imagen = FileUtil.obtenerImagen(rutaImgCompleta);

            List<Categoria> subCategorias = categoriaAdapter.consultarCategoriasHijo(categoria.getId());
            categoria.setSubCategorias(subCategorias);
            categoria.setImagen(imagen);
            consultarCategoriasCiclo(subCategorias);
        }
    }
}
