package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.commons.Curso;

import java.util.List;

public interface CursoAdapter {

    Curso guardarCurso(Curso curso);
    List<Curso> consultarCursosPropios(Integer idProfesor);
    Curso consultarCurso(Integer idCurso);
}
