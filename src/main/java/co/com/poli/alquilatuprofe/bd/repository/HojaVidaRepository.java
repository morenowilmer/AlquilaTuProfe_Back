package co.com.poli.alquilatuprofe.bd.repository;

import co.com.poli.alquilatuprofe.bd.entities.HojaVidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HojaVidaRepository extends JpaRepository<HojaVidaEntity, Integer> {

    List<HojaVidaEntity> findByidUsuario(Integer idUsuario);
}
