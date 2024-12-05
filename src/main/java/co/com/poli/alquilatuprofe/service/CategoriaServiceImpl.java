package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.CategoriaAdapter;
import co.com.poli.alquilatuprofe.model.commons.Categoria;
import co.com.poli.alquilatuprofe.model.exception.AlertaException;
import co.com.poli.alquilatuprofe.model.requester.RegistrarCategoriaRequester;
import co.com.poli.alquilatuprofe.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Value("${imagenes.ruta.base}")
    private String rutaBaseImagenes;

    private final CategoriaAdapter categoriaAdapter;
    private final ModelMapper modelMapper;

    public CategoriaServiceImpl(CategoriaAdapter categoriaAdapter,
                                ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
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

    @Override
    public List<Categoria> consultarSubCategorias(Integer idCategoriaPadre) throws Exception {
        if (Objects.isNull(idCategoriaPadre))
            throw new AlertaException("No se encontro información de la categoria consultada");

        Categoria categoria = categoriaAdapter.consultarCategoria(idCategoriaPadre);

        if (Objects.isNull(categoria))
            throw new AlertaException("No se encontro información de la categoria consultada");

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(categoria);
        consultarCategoriasCiclo(categorias);

        return categorias;
    }

    @Override
    public Categoria registrarCategoria(RegistrarCategoriaRequester requester) throws Exception {
        String rutaCategoria = File.separator.concat("categoria").concat(File.separator)
                .concat(UUID.randomUUID().toString().replace("-", "")).concat(".png");

        FileUtil.guardarImagen(rutaBaseImagenes.concat(rutaCategoria), requester.getImagen());
        Categoria categoria = modelMapper.map(requester, Categoria.class);
        categoria.setRutaImagen(rutaCategoria);
        categoria.setActivo("S");

        return categoriaAdapter.registrarCategoria(categoria);
    }

    private void consultarCategoriasCiclo(List<Categoria> categorias) throws IOException {
        if (Objects.isNull(categorias) || categorias.isEmpty())
            return;

        for (Categoria categoria : categorias) {
            String rutaImgCompleta = rutaBaseImagenes + categoria.getRutaImagen();

            String imagen = null;
            try {
                imagen = FileUtil.obtenerImagen(rutaImgCompleta);
            } catch (Exception e) {
                log.error("Error al obtener la imagen de la categoria: {}", categoria.getNombre());
            }

            List<Categoria> subCategorias = categoriaAdapter.consultarCategoriasHijo(categoria.getId());
            categoria.setSubCategorias(subCategorias);
            categoria.setImagen(imagen);
            consultarCategoriasCiclo(subCategorias);
        }
    }
}
