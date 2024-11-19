package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.CategoriaAdapter;
import co.com.poli.alquilatuprofe.model.commons.Categoria;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CategoriaServiceImpl implements CategoriaService{

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
            String imagen = obtenerImagen(categoria.getRutaImagen());

            List<Categoria> subCategorias = categoriaAdapter.consultarCategoriasHijo(categoria.getId());
            categoria.setSubCategorias(subCategorias);
            categoria.setImagen(imagen);
            consultarCategoriasCiclo(subCategorias);
        }
    }

    private String obtenerImagen(String rutaImagen) throws IOException {

        if (Objects.isNull(rutaImagen) || rutaImagen.isEmpty())
            return null;

        String rutaImgCompleta = rutaBaseImagenes + rutaImagen;
        BufferedImage imagen = ImageIO.read(new File(rutaImgCompleta));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imagen, "png", baos);
        byte[] imageBytes = baos.toByteArray();

        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
