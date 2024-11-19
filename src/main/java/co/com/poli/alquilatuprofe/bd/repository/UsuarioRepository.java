package co.com.poli.alquilatuprofe.bd.repository;

import co.com.poli.alquilatuprofe.bd.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}
