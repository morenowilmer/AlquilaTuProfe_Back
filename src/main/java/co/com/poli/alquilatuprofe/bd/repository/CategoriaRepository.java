package co.com.poli.alquilatuprofe.bd.repository;

import co.com.poli.alquilatuprofe.bd.entities.CategoriaEntity;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

    @Query("SELECT c FROM CategoriaEntity c WHERE c.idCategoriaPadre IS NULL")
    List<CategoriaEntity> listarCategoriasPadre();

    @Query("SELECT c FROM CategoriaEntity c WHERE c.idCategoriaPadre = :idPadre")
    List<CategoriaEntity> listarCategoriasHijo(@PathParam("idPadre") Integer idPadre);
}
