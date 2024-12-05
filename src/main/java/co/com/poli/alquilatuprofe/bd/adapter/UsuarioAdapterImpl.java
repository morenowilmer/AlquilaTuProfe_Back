package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.UsuarioEntity;
import co.com.poli.alquilatuprofe.bd.repository.UsuarioRepository;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioAdapterImpl implements UsuarioAdapter{

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper mapper;

    public UsuarioAdapterImpl(UsuarioRepository usuarioRepository,
                              ModelMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario consultarUsuario(Integer tipoIdentificacion, String identificacion) {
        UsuarioEntity entity = usuarioRepository
                .findByTipoDocumento_idAndIdentificacion(tipoIdentificacion, identificacion);
        return (Objects.nonNull(entity)) ? mapper.map(entity, Usuario.class) : null;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.map(usuario, UsuarioEntity.class);
        return mapper.map(usuarioRepository.save(entity), Usuario.class);
    }
}
