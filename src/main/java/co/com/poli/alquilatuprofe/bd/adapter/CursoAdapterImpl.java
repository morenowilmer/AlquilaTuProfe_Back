package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.CursoEntity;
import co.com.poli.alquilatuprofe.bd.repository.CursoRepository;
import co.com.poli.alquilatuprofe.model.commons.Curso;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CursoAdapterImpl implements CursoAdapter {

    private final CursoRepository cursoRepository;
    private final ModelMapper modelMapper;

    public CursoAdapterImpl(CursoRepository cursoRepository,
                            ModelMapper modelMapper) {
        this.cursoRepository = cursoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Curso guardarCurso(Curso curso) {
        CursoEntity entity = modelMapper.map(curso, CursoEntity.class);
        return modelMapper.map(cursoRepository.save(entity), Curso.class);
    }

    @Override
    public List<Curso> consultarCursosPropios(Integer idProfesor) {
        List<CursoEntity> cursos = cursoRepository.findByidProfesor(idProfesor);
        return (Objects.nonNull(cursos) && !cursos.isEmpty()) ?
                modelMapper.map(cursos, new TypeToken<List<Curso>>() {}.getType()) : Collections.emptyList();
    }

    @Override
    public Curso consultarCurso(Integer idCurso) {
        CursoEntity entity = cursoRepository.findById(idCurso).orElse(null);
        return (Objects.nonNull(entity)) ? modelMapper.map(entity, Curso.class) : null;
    }
}
