package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.CursoAdapter;
import co.com.poli.alquilatuprofe.bd.adapter.MatriculaAdapter;
import co.com.poli.alquilatuprofe.model.commons.Curso;
import co.com.poli.alquilatuprofe.model.commons.InformacionMatricula;
import co.com.poli.alquilatuprofe.model.commons.Matricula;
import co.com.poli.alquilatuprofe.model.enums.EnumEstadoMatricula;
import co.com.poli.alquilatuprofe.model.exception.AlertaException;
import co.com.poli.alquilatuprofe.model.requester.MatricularCursoRequester;
import co.com.poli.alquilatuprofe.model.requester.RegistrarCursoRequester;
import co.com.poli.alquilatuprofe.util.FileUtil;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CursoServiceImpl implements CursoService {

    @Value("${imagenes.ruta.base}")
    private String rutaBaseImagenes;

    private final CursoAdapter cursoAdapter;
    private final MatriculaAdapter matriculaAdapter;
    private final ModelMapper modelMapper;

    public CursoServiceImpl(CursoAdapter cursoAdapter,
                            MatriculaAdapter matriculaAdapter,
                            ModelMapper modelMapper) {
        this.cursoAdapter = cursoAdapter;
        this.matriculaAdapter = matriculaAdapter;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public Curso registrarCurso(RegistrarCursoRequester requester) throws Exception {
        String rutaCurso = File.separator.concat("cursos").concat(File.separator)
                .concat(UUID.randomUUID().toString().replace("-", "")).concat(".png");

        FileUtil.guardarImagen(rutaBaseImagenes.concat(rutaCurso), requester.getImagen());
        Curso curso = modelMapper.map(requester, Curso.class);
        curso.setRutaImagen(rutaCurso);

        return cursoAdapter.guardarCurso(curso);
    }

    @Override
    public List<Curso> consultarCursosPropios(Integer idProfesor) {
        return cursoAdapter.consultarCursosPropios(idProfesor);
    }

    @Transactional
    @Override
    public Boolean matricularCurso(MatricularCursoRequester requester) throws AlertaException {
        Curso curso = cursoAdapter.consultarCurso(requester.getIdCurso());

        if (Objects.isNull(curso))
            throw new AlertaException("No se encontro informacion del curso a matricular.");

        Matricula matricula = modelMapper.map(requester, Matricula.class);
        matricula.setFechaMatricula(LocalDateTime.now());
        matricula.setEstado(EnumEstadoMatricula.MATRICULADO.getValor());
        matricula.setHoraFin(requester.getHoraInicio() + curso.getNroHoras());
        Matricula matriculaGuardada = matriculaAdapter.guardar(matricula);

        return (Objects.nonNull(matriculaGuardada) && Objects.nonNull(matriculaGuardada.getId())
                && matriculaGuardada.getId() > 0);
    }

    @Override
    public List<InformacionMatricula> cursosMatriculados(Integer idAlumno) throws Exception {
        List<InformacionMatricula> informacionMatriculas = matriculaAdapter.cursosMatriculados(idAlumno);

        for (InformacionMatricula informacionMatricula : informacionMatriculas) {
            informacionMatricula.setImagen(FileUtil.obtenerImagen(rutaBaseImagenes.concat(informacionMatricula.getRutaImagen())));
        }

        return informacionMatriculas;
    }
}
