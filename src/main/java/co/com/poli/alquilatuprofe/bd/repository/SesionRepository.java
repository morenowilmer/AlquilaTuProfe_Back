package co.com.poli.alquilatuprofe.bd.repository;

import co.com.poli.alquilatuprofe.bd.entities.SesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepository extends JpaRepository<SesionEntity, String> {

    void deleteAllByUsuario_id(Integer id);
}
