package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.CategoriaEntity;
import co.com.poli.alquilatuprofe.bd.repository.CategoriaRepository;
import co.com.poli.alquilatuprofe.model.commons.Categoria;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CategoriaAdapterImpl implements CategoriaAdapter {

    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    public CategoriaAdapterImpl(CategoriaRepository categoriaRepository,
                                ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria consultarCategoria(Integer id) {
        CategoriaEntity entity = categoriaRepository.findById(id).orElse(null);
        return (Objects.nonNull(entity)) ? modelMapper.map(entity, Categoria.class) : null;
    }

    @Override
    public List<Categoria> consultarCategoriasPadre() {
        List<CategoriaEntity> categorias = categoriaRepository.listarCategoriasPadre();
        return !categorias.isEmpty() ? modelMapper.map(categorias, new TypeToken<List<Categoria>>() {}.getType()) :
                Collections.emptyList();
    }

    @Override
    public List<Categoria> consultarCategoriasHijo(Integer idPadre) {
        List<CategoriaEntity> categorias = categoriaRepository.listarCategoriasHijo(idPadre);
        return !categorias.isEmpty() ? modelMapper.map(categorias, new TypeToken<List<Categoria>>() {}.getType()) :
                Collections.emptyList();
    }

    @Override
    public Categoria registrarCategoria(Categoria categoria) {
        CategoriaEntity entity = modelMapper.map(categoria, CategoriaEntity.class);
        return modelMapper.map(categoriaRepository.save(entity), Categoria.class);
    }
}
