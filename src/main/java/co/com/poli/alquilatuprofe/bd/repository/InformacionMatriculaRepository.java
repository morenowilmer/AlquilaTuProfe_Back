package co.com.poli.alquilatuprofe.bd.repository;

import co.com.poli.alquilatuprofe.bd.entities.InformacionMatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformacionMatriculaRepository extends JpaRepository<InformacionMatriculaEntity, Integer> {

    List<InformacionMatriculaEntity> findByidAlumno(Integer idMatricula);
}
