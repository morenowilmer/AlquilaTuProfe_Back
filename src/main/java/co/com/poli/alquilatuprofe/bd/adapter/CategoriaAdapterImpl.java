package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.CategoriaEntity;
import co.com.poli.alquilatuprofe.bd.repository.CategoriaRepository;
import co.com.poli.alquilatuprofe.model.commons.Categoria;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoriaAdapterImpl implements CategoriaAdapter {

    private final CategoriaRepository categoriaRepository;

    public CategoriaAdapterImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> consultarCategoriasPadre() {
        ModelMapper modelMapper = new ModelMapper();
        List<CategoriaEntity> categorias = categoriaRepository.listarCategoriasPadre();
        return !categorias.isEmpty() ? modelMapper.map(categorias, new TypeToken<List<Categoria>>() {}.getType()) :
                Collections.emptyList();
    }

    @Override
    public List<Categoria> consultarCategoriasHijo(Integer idPadre) {
        ModelMapper modelMapper = new ModelMapper();
        List<CategoriaEntity> categorias = categoriaRepository.listarCategoriasHijo(idPadre);
        return !categorias.isEmpty() ? modelMapper.map(categorias, new TypeToken<List<Categoria>>() {}.getType()) :
                Collections.emptyList();
    }
}
