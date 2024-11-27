package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.SesionEntity;
import co.com.poli.alquilatuprofe.bd.repository.SesionRepository;
import co.com.poli.alquilatuprofe.model.commons.Sesion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SesionAdapterImpl implements SesionAdapter {

    private final SesionRepository sesionRepository;
    private final ModelMapper mapper = new ModelMapper();

    public SesionAdapterImpl(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    @Override
    public void guardarSesion(Sesion sesion) {
        SesionEntity entity = mapper.map(sesion, SesionEntity.class);
        sesionRepository.save(entity);
    }

    @Override
    public Sesion obtenerSesion(String id) {
        SesionEntity entity = sesionRepository.findById(id).orElse(null);
        return (Objects.nonNull(entity)) ? mapper.map(entity, Sesion.class) : null;
    }

    @Override
    public void eliminarSesion(String id) {
        sesionRepository.deleteById(id);
    }

    @Override
    public void eliminarSesionesUsuario(Integer idUsuario) {
        sesionRepository.deleteAllByUsuario_id(idUsuario);
    }
}
