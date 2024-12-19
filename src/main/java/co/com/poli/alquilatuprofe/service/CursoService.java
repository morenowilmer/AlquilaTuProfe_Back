package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.model.commons.Curso;
import co.com.poli.alquilatuprofe.model.commons.InformacionMatricula;
import co.com.poli.alquilatuprofe.model.exception.AlertaException;
import co.com.poli.alquilatuprofe.model.requester.MatricularCursoRequester;
import co.com.poli.alquilatuprofe.model.requester.RegistrarCursoRequester;

import java.util.List;

public interface CursoService {

    Curso registrarCurso(RegistrarCursoRequester requester) throws Exception;
    List<Curso> consultarCursosPropios(Integer idProfesor);
    Boolean matricularCurso(MatricularCursoRequester requester) throws AlertaException;
    List<InformacionMatricula> cursosMatriculados(Integer idAlumno) throws Exception;
}
