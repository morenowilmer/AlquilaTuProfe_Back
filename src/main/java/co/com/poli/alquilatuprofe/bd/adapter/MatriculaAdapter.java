package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.commons.InformacionMatricula;
import co.com.poli.alquilatuprofe.model.commons.Matricula;

import java.util.List;

public interface MatriculaAdapter {

    Matricula guardar(Matricula matricula);
    List<InformacionMatricula> cursosMatriculados(Integer idAlumno);
}
