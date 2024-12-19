package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.InformacionMatriculaEntity;
import co.com.poli.alquilatuprofe.bd.entities.MatriculaEntity;
import co.com.poli.alquilatuprofe.bd.repository.InformacionMatriculaRepository;
import co.com.poli.alquilatuprofe.bd.repository.MatriculaRepository;
import co.com.poli.alquilatuprofe.model.commons.InformacionMatricula;
import co.com.poli.alquilatuprofe.model.commons.Matricula;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class MatriculaAdapterImpl implements MatriculaAdapter {

    private final MatriculaRepository matriculaRepository;
    private final InformacionMatriculaRepository informacionMatriculaRepository;
    private final ModelMapper modelMapper;

    public MatriculaAdapterImpl(MatriculaRepository matriculaRepository,
                                InformacionMatriculaRepository informacionMatriculaRepository,
                                ModelMapper modelMapper) {
        this.matriculaRepository = matriculaRepository;
        this.informacionMatriculaRepository = informacionMatriculaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        MatriculaEntity entity = modelMapper.map(matricula, MatriculaEntity.class);
        return modelMapper.map(matriculaRepository.save(entity), Matricula.class);
    }

    @Override
    public List<InformacionMatricula> cursosMatriculados(Integer idAlumno) {
        List<InformacionMatriculaEntity> informacionMatriculas = informacionMatriculaRepository
                .findByidAlumno(idAlumno);
        return (Objects.nonNull(informacionMatriculas) && !informacionMatriculas.isEmpty()) ?
                modelMapper.map(informacionMatriculas, new TypeToken<List<InformacionMatricula>>() {}.getType()) :
                Collections.emptyList();
    }
}
